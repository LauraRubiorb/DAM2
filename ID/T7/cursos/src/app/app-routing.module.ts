import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformacionComponent } from './componets/informacion/informacion.component';
import { CursosComponent } from './componets/cursos/cursos.component';
import { BuscadorComponent } from './componets/buscador/buscador.component';
import { PracticaComponent } from './componets/practica/practica.component';

//una ruta es un json: tiene el pad y el componente
const routes: Routes = [
  {
    path: 'cursos',
    component: CursosComponent,
  },
  {
    path: 'buscador',
    component: BuscadorComponent,
  },
  {
    path: 'practica',
    component: PracticaComponent,
  },
  {
    path: 'buscador/:curso', //parametros nominales: capturacion por nombre
    //? si quieres lo pasas y sino nop/:?id
    component: BuscadorComponent,
  },
  {
    path: 'info',
    component: InformacionComponent,
  },
  {
    path: '**', // con esto consigo que se carge el primero, ponerlo el ultimo
    redirectTo: 'info',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
