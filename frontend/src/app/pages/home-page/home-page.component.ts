import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ExpressionService } from 'src/app/styles/expression.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
})
export class HomePageComponent {
  constructor(public styles: ExpressionService, private router: Router) {}

  ngOnInit() {
  }
  public getStartedHandler() {
    this.router.navigateByUrl("about");
  }
}
