import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { log } from 'console';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'ejercicio';

  //para navegar:
  //1. Constructor: Router @angular
  constructor(private rutas: Router) {}

  navegar(tipo: string) {
    this.rutas.navigate(['moda', tipo]);
    console.log(tipo);
  }
}
