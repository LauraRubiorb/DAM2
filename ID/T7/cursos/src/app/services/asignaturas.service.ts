import { Injectable } from '@angular/core';
import { AsignaturaInterfaz } from '../model/asingatura';
@Injectable({
  providedIn: 'root',
})
export class AsignaturasService {
  private asignaturas: AsignaturaInterfaz[] = [
    {
      nombre: 'Programacion',
      siglas: 'PRO',
      horas: 8,
      profesor: 'Borja Martin Herrera',
      curso: 'DAM|DAW',
      nivel: 1,
      conocimientos: ['Java', 'MySQL', 'Algoritmos', 'Ficheros'],
      imagen: '',
    },
    {
      nombre: 'Sistemas',
      siglas: 'SI',
      horas: 6,
      profesor: 'Luis Miguel Serrano',
      curso: 'DAM|DAW',
      nivel: 1,
      conocimientos: ['Windows', 'Linux', 'Bash', 'Powershell'],
      imagen: '',
    },
    {
      nombre: 'Programacion multimedia',
      siglas: 'PMDM',
      horas: 5,
      profesor: 'Borja Martin Herrera',
      curso: 'DAM',
      nivel: 2,
      conocimientos: ['Java', 'Kotlin', 'Firebase', 'XML'],
      imagen:
        'https://sm.pcmag.com/pcmag_au/review/g/google-and/google-android-11_egj3.png',
    },
    {
      nombre: 'Desarrollo Interfaces',
      siglas: 'DI',
      horas: 5,
      profesor: 'Borja Martin Herrera',
      curso: 'DAM',
      nivel: 2,
      conocimientos: ['Java', 'JavaFX', 'JS', 'Angular'],
      imagen:
        'https://malcoded.com/static/3cc4cb18747975e37af4cc86dbd62ed3/f3583/angular-i18n.png',
    },
    {
      nombre: 'Ingles',
      siglas: 'ING',
      horas: 2,
      profesor: 'Rocio Pizarro',
      curso: 'DAM|DAW',
      nivel: 2,
      conocimientos: ['Ingles', 'tecnologia', 'vocabulario'],
      imagen:
        'https://img.freepik.com/vector-gratis/fondo-libro-ingles-dibujado-mano_23-2149483338.jpg',
    },
    {
      nombre: 'Desarrollo web en entorno cliente',
      siglas: 'DWEC',
      horas: 6,
      profesor: 'Borja Martin',
      curso: 'DAW',
      nivel: 2,
      conocimientos: ['JS', 'tecnologia', 'vocabulario'],
      imagen:
        'https://www.comunicare.es/wp-content/uploads/2021/07/javascript.jpg',
    },
    {
      nombre: 'Desarrollo web en entorno servidos',
      siglas: 'DWES',
      horas: 6,
      profesor: 'Borja Martin',
      curso: 'DAW',
      nivel: 2,
      conocimientos: ['JS', 'TS', 'PHP'],
      imagen: 'https://bigarsolucion.es/wp-content/uploads/2020/11/unnamed.jpg',
    },
  ];

  constructor() {}

  getProfesorAsignatura(nombre: string): AsignaturaInterfaz[] {
    let resultado = this.asignaturas.filter((item: AsignaturaInterfaz) => {
      return item.profesor == nombre;
    });
    return resultado;
  }
  getConocimientoAsignatura(nombre: string): AsignaturaInterfaz[] {
    let resultado: AsignaturaInterfaz[] = [];
    this.asignaturas.forEach((item: AsignaturaInterfaz) => {
      if (item.conocimientos.includes(nombre)) {
        resultado.push(item);
      }
    });
    return resultado;
  }
  getCursoAsignatura(curso: string): AsignaturaInterfaz[] {
    let resultado = this.asignaturas.filter((item: AsignaturaInterfaz) => {
      return item.curso.includes(curso);
    });
    return resultado;
  }

  getAllAsignaturas(): AsignaturaInterfaz[] {
    return this.asignaturas;
  }
}
