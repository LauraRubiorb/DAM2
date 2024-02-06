import { Injectable } from '@angular/core';
import { AsignaturaInterfaz } from '../model/asingatura';
@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  private lista_asignatura: AsignaturaInterfaz[] = [
    {
      nombre: 'Programacion multimedia',
      siglas: 'PMDM',
      horas: 5,
      profesor: 'Borja',
      curso: 'DAM',
      nivel: 2,
      conocimientos: ['Java', 'Kotlin'],
      imagen: '',
    },
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      horas: 8,
      profesor: 'Borja',
      curso: 'DAM',
      nivel: 1,
      conocimientos: ['Java', 'MySql', 'ficheros', 'Algoritmos'],
      imagen: 'https://cdn-icons-png.flaticon.com/512/2728/2728262.png',
    },
    {
      nombre: 'Sistemas informaticos',
      siglas: 'SI',
      horas: 6,
      profesor: 'Sandra',
      curso: 'DAM',
      nivel: 1,
      conocimientos: ['Windows', 'Powerself', 'Bash'],
      imagen:
        'https://c0.klipartz.com/pngpicture/381/572/gratis-png-red-informatica-sistema-informatico-servidores-informaticos-software-informatico-tecnologia.png',
    },
    {
      nombre: 'Ingles',
      siglas: 'I',
      horas: 3,
      profesor: 'Rocio',
      curso: 'DAM',
      nivel: 2,
      conocimientos: ['Tecnologias', 'Verbos', 'Vocabulary'],
      imagen: '',
    },
  ];

  constructor() {}

  getAllAsignaturas(): asignatura[] {
    return this.lista_asignatura
  }
}
