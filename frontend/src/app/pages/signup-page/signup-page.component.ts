import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
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
      emailID: [''],
      firstName: [''],
      lastName: [''],
      password: [''],
      role: ["patient"],
      sex: [''],
      complaint: ['']
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
    let data = {
      user: {
        emailID: this.signupForm.value.emailID,
        firstName: this.signupForm.value.firstName,
        lastName: this.signupForm.value.lastName,
        password: this.signupForm.value.password,
        role:"patient",
        sex: this.signupForm.value.sex,
      },
      patient:{
        complaint: this.signupForm.value.complaint
      }
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
