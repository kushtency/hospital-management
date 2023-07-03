import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExpressionService } from 'src/app/styles/expression.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})

export class SignupPageComponent {

  firstPage = false;
  secondPagePatient = false;
  secondPagePhysician = false;
  step = 1;

  signupForm !: FormGroup;
  physicianForm !: FormGroup;
  patientForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, public styles: ExpressionService,private httpClient: HttpClient) {}
  ngOnInit(){
    this.signupForm = this.formBuilder.group({
      emailID: [''],
      firstName: [''],
      lastName: [''],
      password: [''],
      role:[''],
      sex: ['']
    });
    this.physicianForm = this.formBuilder.group({
      complaint:['']
    })
    this.patientForm = this.formBuilder.group({
      title:[''],
      address:[''],
      speciality:['']
    })
  }

  next(){
    if(this.step==1){
          this.firstPage = true;
          if (this.signupForm.invalid) { return  }
          if(this.signupForm.value.role === "patient")
          this.step++
          if(this.signupForm.value.role === "physician")
          this.step+=2;
    }
    if(this.step==2){
        this.secondPagePatient = true;
        this.firstPage = false;
        if (this.patientForm.invalid) { return }
            // this.step++;
    }
    if(this.step==3){
        this.secondPagePhysician = true;
        this.firstPage = false;
        if(this.physicianForm.invalid){return}
        // this.step++;
      }
  }
  previous(){
    this.step--
    if(this.step==2){
      this.step--;
      this.secondPagePatient = false;
      this.secondPagePhysician = false;
    }
    else if(this.step==1){
      this.secondPagePatient = false;
      this.secondPagePhysician = false;
    }
  }

  signupHandler() {
    let data = {
      "user":this.signupForm.value,
      "physician":this.physicianForm.value,
      "patient":this.patientForm.value,
    }
    console.log(data);

    // this.httpClient.post('localhost:8080/api/public/register/', this.signupForm.value).subscribe({
    //   next: (response) => console.log(response),
    //   error: (error) => console.log(error),
    // });
  }

}
