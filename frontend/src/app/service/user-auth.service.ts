import { Injectable } from '@angular/core';
import { user } from '../types/TYPE';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService {
  constructor() {}

  get GetUser(): user {
    return JSON.parse(localStorage.getItem('user') as string);
  }

  get GetToken(): string{
    return JSON.parse(localStorage.getItem('user') as string).token;
  }

  public StoreUser(user: user) {
    localStorage.setItem('user', JSON.stringify(user));
  }
  
  public removeUser() {
    localStorage.removeItem('user');
  }
}
