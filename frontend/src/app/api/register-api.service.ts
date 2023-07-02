import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PUBLIC_API } from '../constants/URL';

@Injectable({
  providedIn: 'root',
})
export class RegisterApiService {
  constructor(private http: HttpClient) {}

  public register(user: any) {
    return this.http.post(`${PUBLIC_API}register/`, user);
  }

  public login(user: any) {
    return this.http.post(`${PUBLIC_API}login/`, user);
  }
  
}
