import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { ContactoComponent } from './component/contacto/contacto.component';
import { ModaComponent } from './component/moda/moda.component';
import { HomeComponent } from './component/home/home.component';
import { MujerComponent } from './component/mujer/mujer.component';

const routes: Routes = [
  {
    path: 'contacto',
    component: ContactoComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'moda/:tipo',
    component: ModaComponent,
  },
  {
    path: '**',
    redirectTo: 'home',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
