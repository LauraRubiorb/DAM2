import { Component } from '@angular/core';
import { PrendasInterfaz } from '../../model/prendas';
import { RopaService } from '../../service/ropa.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  lista_ropas: PrendasInterfaz[] = [];

  constructor(private service : RopaService){
    this.lista_ropas = service.getAllPrendas()
  }
}
