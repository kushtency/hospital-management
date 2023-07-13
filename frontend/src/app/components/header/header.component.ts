import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/app/service/user-auth.service';
import { StatesService } from 'src/app/store/states.service';
import { ExpressionService } from 'src/app/styles/expression.service';
import { user } from 'src/app/types/TYPE';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  
  constructor(
    private router: Router,
    public styles: ExpressionService,
    private userService: UserAuthService,
    private states: StatesService,
  ) {}


  ngOnInit() {
    if(this.userService.GetUser){
      this.states.isloggedIn.set(true);
    }
  }

  get LoggedIn(): boolean {
    return this.states?.isloggedIn();
  }

  get UserName(): string {
    const user: user = this.userService.GetUser;
    return user.name;
  }

  public logoutHandler() {
    // this.states.isloggedIn.set(false);
    this.states.isloggedIn.set(false);
    this.userService.removeUser();
    this.router.navigateByUrl('');
  }
}
