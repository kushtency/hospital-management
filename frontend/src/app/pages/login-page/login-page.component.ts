import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { RegisterApiService } from 'src/app/api/register-api.service';
import { ExpressionService } from 'src/app/styles/expression.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
  signinForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, public styles: ExpressionService, private login:RegisterApiService) {}
  ngOnInit(){
    this.signinForm = this.formBuilder.group({
      emailID: new FormControl('', [Validators.maxLength(255), Validators.required]),
      password: new FormControl('', [Validators.maxLength(30), Validators.required]),
    });
    console.log(this.signinForm);
  }
  signinHandler() {
    console.log(this.signinForm);
    console.log(this.signinForm.get("emailID")); 
    this.login.login(this.signinForm.value).subscribe({
      next:function(val){
        console.log(val);
      },
      error:(err)=>{console.log(err);}
    });
  }

  get EmailID(): FormControl {
    return this.signinForm.get("emailID") as FormControl;
  }

  get Password(): FormControl {
    return this.signinForm.get("password") as FormControl;
  }
}
