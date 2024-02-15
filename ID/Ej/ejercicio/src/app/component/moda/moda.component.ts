import { Component, Input, input } from '@angular/core';
import { RopaService } from '../../service/ropa.service';
import { PrendasClass, PrendasInterfaz } from '../../model/prendas';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-moda',
  templateUrl: './moda.component.html',
  styleUrl: './moda.component.css',
})
export class ModaComponent {
  lista_ropas: PrendasInterfaz[] = [];

  // Para poder acceder a toda la ropa deberemos tener un constructor donde este el service:

  //private para poder utilizarlo mas tarde(var de clase)

  constructor(
    private service: RopaService,
    private rutaActiva: ActivatedRoute
  ) {
    this.rutaActiva.paramMap.subscribe((item: ParamMap) => {
      let tipo: any = item.get('tipo');
      console.log(tipo);
      
      if (tipo == 'mujer') {
        this.lista_ropas = this.service.getMujerPrendas();
      } else if (tipo == 'hombre') {
        this.lista_ropas = this.service.getHombrePrendas();
      } else if (tipo == 'ninix') {
        this.lista_ropas = this.service.getNinioPrendas();
      } else if (tipo == 'todo') {
        this.lista_ropas = this.service.getAllPrendas();
      }
    });
  }
}
