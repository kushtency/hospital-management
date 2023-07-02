import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExpressionService } from 'src/app/styles/expression.service';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent {
  signupForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, public styles: ExpressionService) {}
  ngOnInit(){
    this.signupForm = this.formBuilder.group({
      emailID: [''],
      firstName: [''],
      lastName: [''],
      password: [''],
      sex: ['']
    });
  }
  signupHandler() {
    console.log(this.signupForm.value)
  }

}
