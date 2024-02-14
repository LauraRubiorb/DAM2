import { Component } from '@angular/core';
import { AsignaturaInterfaz } from '../../model/asingatura';
import { AsignaturasService } from '../../services/asignaturas.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { log } from 'node:console';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css',
})
export class BuscadorComponent {
  asignaturas: AsignaturaInterfaz[] = [];
  nombre: string = '';
  asignatura: string = '';
  conocimiento: string = '';

  asignatuasFiltrar: AsignaturaInterfaz[] = [];
  constructor(
    private servicio: AsignaturasService,
    private rutaActiva: ActivatedRoute
  ) {
    //this.rutaActiva.snapshot.params['curso'];
    this.rutaActiva.paramMap.subscribe((item: ParamMap) => {
      //console.log('ejemplo');
      item.get('curso');
      let seleccion: any = item.get('curso');
      this.asignatuasFiltrar = this.servicio.getCursoAsignatura(seleccion);
      this.asignatura = seleccion;
    });
  } //recibir datos : modulo activatedRoute

  //si navego a dam se pondra dam auto y sus asig al contrario que daw
  realizarBusqueda(nombre: string, asignatura: string, conocimiento: string) {}
}
