import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InformacionComponent } from './componets/informacion/informacion.component';
import { CursosComponent } from './componets/cursos/cursos.component';
import { ImagenesPipe } from './pipes/imagenes.pipe';
import { AsignaturasService } from './services/asignaturas.service';
import { BuscadorComponent } from './componets/buscador/buscador.component';
import { FormsModule } from '@angular/forms';
import { CartaAsignaturaComponent } from './componets/carta-asignatura/carta-asignatura.component';
import { PracticaComponent } from './componets/practica/practica.component';

@NgModule({
  declarations: [
    AppComponent,
    InformacionComponent,
    CursosComponent,
    ImagenesPipe,
    BuscadorComponent,
    CartaAsignaturaComponent,
    PracticaComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration(), AsignaturasService],
  bootstrap: [AppComponent],
})
export class AppModule {}
