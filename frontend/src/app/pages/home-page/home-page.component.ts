import { Component } from '@angular/core';
import { RegisterApiService } from '../../api/register-api.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
})
export class HomePageComponent {
  constructor(private registerAPI: RegisterApiService) {}

  ngOnInit() {
  }
}
