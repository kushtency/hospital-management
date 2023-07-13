import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StatesService {
  isloggedIn = signal(false);
  constructor() { }
  get LoggedIn(): boolean {
    return this.isloggedIn()
  }
  public setIsLoggedIn(flag: boolean) {
    this.isloggedIn.set(flag);
  }
}
