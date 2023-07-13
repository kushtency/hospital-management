import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StatesService {
  isloggedIn = signal(false);
  constructor() { }
}
