import { Component } from '@angular/core';
import { AsignaturaClase, AsignaturaInterfaz } from '../../model/asingatura';
import { AsignaturasService } from '../../services/asignaturas.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css',
})

//https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/android-icon.png

//https://images.vexels.com/media/users/3/201997/isolated/preview/ea210d04b9b9a0c0b3f65da99c46c228-libro-de-ingles-plano.png
export class CursosComponent {
  asignaturas: lista_asignatura[] = [];
  constructor(private servicio: AsignaturasService) {}
}
