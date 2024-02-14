import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'cursos';

  constructor(private rutas: Router) {
    //private var de clase
  }
  navegar(curso: string) {
    //pedir el acceso a un modulo
    this.rutas.navigate(['buscador', curso]);
  }
}
