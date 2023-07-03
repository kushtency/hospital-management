import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExpressionService } from 'src/app/styles/expression.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
  signinForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, public styles: ExpressionService) {}
  ngOnInit(){
    this.signinForm = this.formBuilder.group({
      emailID: [''],
      password: [''],
      role:['']
    });
  }
  signinHandler() {
    console.log(this.signinForm.value)
  }
}
