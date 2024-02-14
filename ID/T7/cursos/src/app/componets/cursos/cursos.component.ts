import { Component } from '@angular/core';
import { AsignaturaInterfaz } from '../../model/asingatura';
import { AsignaturasService } from '../../services/asignaturas.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css',
})

//https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/android-icon.png

//https://images.vexels.com/media/users/3/201997/isolated/preview/ea210d04b9b9a0c0b3f65da99c46c228-libro-de-ingles-plano.png
export class CursosComponent {
  asignaturas: AsignaturaInterfaz[] = [];
  constructor(private servicio: AsignaturasService) {
    this.asignaturas = this.servicio.getAllAsignaturas();
  }
}

//crear un componente: buscador 
//crear una ruta para poder navegar a el
//crear un buscador en el componente que consuma datos del servicio
  //busqueda por: conocimineot, curso, profesor
