import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ExpressionService } from 'src/app/styles/expression.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  constructor(private router: Router, public styles: ExpressionService) {}
}
