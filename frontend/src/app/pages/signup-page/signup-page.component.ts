import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ExpressionService } from 'src/app/styles/expression.service';
import { HttpClient } from '@angular/common/http';
import { RegisterApiService } from 'src/app/api/register-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css'],
})
export class SignupPageComponent {

  step = 1;

  signupForm !: FormGroup;
  // physicianForm !: FormGroup;
  successForm !: FormGroup;
  // patientForm !: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    public styles: ExpressionService,
    private register: RegisterApiService,
    private router: Router
  ) {}

  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      emailID: new FormControl('', [Validators.maxLength(255), Validators.required]),
      firstName: new FormControl('', [Validators.maxLength(255), Validators.required]),
      lastName: new FormControl('', [Validators.maxLength(255), Validators.required]),
      password: new FormControl('', [Validators.maxLength(255), Validators.required]),
      role: ["patient"],
      sex: [''],
      age: new FormControl('', [Validators.maxLength(255), Validators.required]),
      complaint: new FormControl('', [Validators.maxLength(30), Validators.required]),
    });
    // this.patientForm = this.formBuilder.group({
    //   complaint: [''],
    // });
    // this.physicianForm = this.formBuilder.group({
    //   title: [''],
    //   address: [''],
    //   speciality: [''],
    // });
  }
  get EmailID(): FormControl {
    return this.signupForm.get("emailID") as FormControl;
  }

  get Password(): FormControl {
    return this.signupForm.get("password") as FormControl;
  }

  get First(): FormControl {
    return this.signupForm.get("firstName") as FormControl;
  }

  get Last(): FormControl {
    return this.signupForm.get("lastName") as FormControl;
  }

  get Complaint(): FormControl {
    return this.signupForm.get("complaint") as FormControl;
  }
  
  get Sex(): FormControl {
    return this.signupForm.get("sex") as FormControl;
  }

  get Age(): FormControl {
    return this.signupForm.get("age") as FormControl;
  }

  next() {
    if (this.step == 1) {
      if (this.signupForm.invalid) {
        return;
      }
      // if (this.signupForm.value.role === 'patient') this.step++;
      // if (this.signupForm.value.role === 'physician') this.step += 2;
    }
    if (this.step == 2) {
      if (this.successForm.invalid) {
        return;
      }
      // this.step++;
    }
    // if (this.step == 3) {
    //   if (this.physicianForm.invalid) {
    //     return;
    //   }
    //   // this.step++;
    // }
  }
  // previous() {
  //   this.step--;
  //   if (this.step == 2) {
  //     this.step--;
  //   } else if (this.step == 1) {
  //   }
  // }

  signupHandler() {

    this.EmailID.markAsTouched();
    this.Complaint.markAsTouched();
    this.First.markAsTouched();
    this.Last.markAsTouched();
    this.Password.markAsTouched();
    this.Sex.markAsTouched();
    this.Age.markAsTouched();

    if(this.signupForm.value.emailID==='' || this.signupForm.value.firstName==='' || this.signupForm.value.lastName==='' || this.signupForm.value.password==='' || this.signupForm.value.sex==='' || this.signupForm.value.complaint==='' || (this.signupForm.value.age>1 && this.signupForm.value.age<=100))
    {
      return;
    }
    let data = {
      user: {
        emailID: this.signupForm.value.emailID,
        name: this.signupForm.value.firstName + ' ' + this.signupForm.value.lastName,
        password: this.signupForm.value.password,
        role:"patient",
        sex: this.signupForm.value.sex,
      },
      patient:{
        complaint: this.signupForm.value.complaint
      },
      physician:''
      // physician: this.physicianForm.value,
      // patient: this.patientForm.value,
    };
    console.log(data);
    this.register.register(data).subscribe({
      next:(val)=>{
        ///next page
        this.step++;
        console.log(val);
      },
      error:(err)=>{
        console.log(err);
      }
    });
  }

  onSubmit(){
    console.log("login page");
    this.router.navigate(['/login']);
  }

}
