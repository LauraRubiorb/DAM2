import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformacionComponent } from './componets/informacion/informacion.component';
import { CursosComponent } from './componets/cursos/cursos.component';

//una ruta es un json: tiene el pad y el componente
const routes: Routes = [
  {
    path: 'informacion',
    component: InformacionComponent,
  },
  {
    path: 'cursos',
    component: CursosComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
