import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { RegisterApiService } from 'src/app/api/register-api.service';
import { UserAuthService } from 'src/app/service/user-auth.service';
import { StatesService } from 'src/app/store/states.service';
import { ExpressionService } from 'src/app/styles/expression.service';
import { user } from 'src/app/types/TYPE';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent {
  signinForm!: FormGroup;
  showError: Boolean = false;
  errorMsg?: string;

  constructor(
    private formBuilder: FormBuilder,
    public styles: ExpressionService,
    private login: RegisterApiService,
    private userService: UserAuthService,
    private states: StatesService,
  ) {}
  ngOnInit() {
    this.signinForm = this.formBuilder.group({
      emailID: new FormControl('', [
        Validators.maxLength(255),
        Validators.required,
        Validators.email,
      ]),
      password: new FormControl('', [
        Validators.maxLength(30),
        Validators.required,
      ]),
    });
    console.log(this.signinForm);
  }
  signinHandler() {

    // if user is already logged in redirect to the dashboard
    if(this.userService.GetUser){
      return;
    }
    this.EmailID.markAsTouched();
    this.Password.markAsTouched();
    if (this.EmailID.value === '' || this.Password.value === '') {
      this.showError = true;
      this.errorMsg = '*please enter all the details';
      return;
    }
    this.showError = false;
    this.login.login(this.signinForm.value).subscribe({
      next: this.loginCall,
      error: this.errorCall,
    });

  }

  private loginCall = (res : any) => {
    const details = res.details;
    if(res.message.status === 1){
      const user: user = {
        name: details.name,
        emailID: details.emailID,
        sex: details.sex,
        role: details.role,
        age: details.age,
        token: res.token
      }
      this.userService.StoreUser(user);
      this.states.isloggedIn.set(true);
    }
  }

  private errorCall = (err : any) => {
    console.log(err)
  }

  get EmailID(): FormControl {
    return this.signinForm.get('emailID') as FormControl;
  }

  get Password(): FormControl {
    return this.signinForm.get('password') as FormControl;
  }
}
