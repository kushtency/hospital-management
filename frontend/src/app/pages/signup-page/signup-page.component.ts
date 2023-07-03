import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExpressionService } from 'src/app/styles/expression.service';
import { RegisterApiService } from 'src/app/api/register-api.service';



@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})

export class SignupPageComponent {

  step = 1;

  signupForm !: FormGroup;
  physicianForm !: FormGroup;
  patientForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, public styles: ExpressionService,private register:RegisterApiService) {}
  ngOnInit(){
    this.signupForm = this.formBuilder.group({
      emailID: [''],
      firstName: [''],
      lastName: [''],
      password: [''],
      role:[''],
      sex: ['']
    });
    this.patientForm = this.formBuilder.group({
      complaint:['']
    })
    this.physicianForm = this.formBuilder.group({
      title:[''],
      address:[''],
      speciality:['']
    })
  }

  next(){
    if(this.step==1){
          if (this.signupForm.invalid) { return  }
          if(this.signupForm.value.role === "patient")
          this.step++
          if(this.signupForm.value.role === "physician")
          this.step+=2;
    }
    if(this.step==2){
        if (this.patientForm.invalid) { return }
            // this.step++;
    }
    if(this.step==3){
        if(this.physicianForm.invalid){return}
        // this.step++;
      }
  }
  previous(){
    this.step--
    if(this.step==2){
      this.step--;
    }
  }

  signupHandler() {
    let data = {
      "user":this.signupForm.value,
      "physician":this.physicianForm.value,
      "patient":this.patientForm.value,
    }
    console.log(data);
    this.register.register(data).subscribe({
      next:function(val){
        ///next page
        console.log(val);
      },
      error:(err)=>{
        console.log(err);
      }
    });
  }

}
