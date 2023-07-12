import { Component } from '@angular/core';
import { ExpressionService } from 'src/app/styles/expression.service';

@Component({
  selector: 'app-about-page',
  templateUrl: './about-page.component.html',
  styleUrls: ['./about-page.component.css']
})
export class AboutPageComponent {
  constructor(public styles: ExpressionService) {}
  
}
