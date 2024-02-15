import { Injectable } from '@angular/core';
import { PrendasInterfaz } from '../model/prendas';
import { ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class RopaService {
  private prendas: PrendasInterfaz[] = [
    {
      nombre: 'Abrigo marrón largo',
      tipo: 'mujer',
      precio: 68,
      tallas: ['S', 'M', 'L'],
      imagen: 'https://m.media-amazon.com/images/I/51RBhh9PVNL.jpg',
      categoria: 'Invierno',
    },
    {
      nombre: 'Abrigo verde largo',
      tipo: 'hombre',
      precio: 55,
      tallas: ['M', 'L', 'XL'],
      imagen:
        'https://cdn.grupoelcorteingles.es/SGFM/dctm/MEDIA03/202307/12/00110968302892____6__516x640.jpg',
      categoria: 'Invierno',
    },
    {
      nombre: 'Plumas rojo',
      tipo: 'ninix',
      precio: 30,
      tallas: ['XS', 'S', 'M', 'L'],
      imagen:
        'https://scorer.es/105998-large_default/abrigo-converse-solid-mdwt.jpg',
      categoria: 'Invierno',
    },
    {
      nombre: 'Camisa azul',
      tipo: ' ninix',
      precio: 15,
      tallas: ['XS', 'S', 'M', 'L'],
      imagen:
        'https://lalazada.es/wp-content/uploads/2020/02/Camisa-azul-b%C3%A1sica-beb%C3%A9-ni%C3%B1o-.Mayoral..jpg',
      categoria: 'Formal',
    },
    {
      nombre: 'Camisa elegante',
      tipo: ' mujer',
      precio: 35,
      tallas: ['XS', 'S', 'M', 'L', 'XL'],
      imagen:
        'https://m.media-amazon.com/images/I/61SFFw1L6eL._AC_UF894,1000_QL80_.jpg',
      categoria: 'Formal',
    },
    {
      nombre: 'Camisa elegante',
      tipo: ' hombre',
      precio: 43,
      tallas: ['S', 'M', 'L', 'XL'],
      imagen:
        'https://www.bolf.es/spa_pl_Camisa-elegante-de-manga-larga-para-hombre-gris-Bolf-5796-1-89738_1.jpg',
      categoria: 'Formal',
    },
    {
      nombre: 'camiseta',
      tipo: ' hombre',
      precio: 10,
      tallas: ['S', 'M', 'L', 'XL'],
      imagen: '',
      categoria: 'Deporte',
    },
    {
      nombre: 'camiseta',
      tipo: ' mujer',
      precio: 10,
      tallas: ['S', 'M'],
      imagen: '',
      categoria: 'Deporte',
    },
    {
      nombre: 'camiseta',
      tipo: ' ninix',
      precio: 7,
      tallas: ['S', 'M'],
      imagen: '',
      categoria: 'Deporte',
    },
  ];
  private resultado: PrendasInterfaz[] = [];

  getAllPrendas(): PrendasInterfaz[] {
    return this.prendas;
  }
  getMujerPrendas(): PrendasInterfaz[] {
    this.resultado = this.prendas.filter((item: PrendasInterfaz) => {
      this.resultado.push(item);
      return item.tipo == 'mujer';
    });
    return this.resultado;
  }
  getHombrePrendas(): PrendasInterfaz[] {
    this.resultado = this.prendas.filter((item: PrendasInterfaz) => {
      return item.tipo == 'hombre';
    });
    return this.resultado;
  }
  getNinioPrendas(): PrendasInterfaz[] {
    this.resultado = this.prendas.filter((item: PrendasInterfaz) => {
      return item.tipo == 'ninix';
    });
    return this.resultado;
  }
}
