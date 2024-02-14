import { Component, Input } from '@angular/core';
import { AsignaturaInterfaz } from '../../model/asingatura';

@Component({
  selector: 'app-carta-asignatura',
  templateUrl: './carta-asignatura.component.html',
  styleUrl: './carta-asignatura.component.css'
})
export class CartaAsignaturaComponent {
  @Input() asignatura : AsignaturaInterfaz = {nombre: "", siglas: "",horas: 2, profesor:"", curso: "",
    nivel: 2,
    conocimientos: [],
    imagen: ""}
}
