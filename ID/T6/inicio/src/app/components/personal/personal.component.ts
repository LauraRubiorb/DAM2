import { Component } from '@angular/core';

@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrl: './personal.component.css',
})
export class PersonalComponent {
  imagenPerfil: String =
    'https://img.freepik.com/vector-premium/icono-perfil-usuario-estilo-plano-ilustracion-vector-avatar-miembro-sobre-fondo-aislado-concepto-negocio-signo-permiso-humano_157943-15752.jpg';
  textoBoton: String = 'Mostrar';
  mostrarContenido = false;
  pulsacionBoton() {

    if (this.mostrarContenido) {
      this.textoBoton = 'Ocultar';
      this.mostrarContenido = false;
    } else {
      this.textoBoton = 'Mostrar';
      this.mostrarContenido = true;
    }
    //if ternario-> ? si se cumple tal ---- : si no se cumple tal

    /*this.mostrarContenido
      ? (this.textoBoton = 'Ocultar')
      : (this.textoBoton = 'Mostrar'); */
  }
}
