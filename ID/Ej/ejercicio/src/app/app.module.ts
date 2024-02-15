import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactoComponent } from './component/contacto/contacto.component';
import { ModaComponent } from './component/moda/moda.component';
import { HomeComponent } from './component/home/home.component';
import { MujerComponent } from './component/mujer/mujer.component';
import { HombreComponent } from './component/hombre/hombre.component';
import { NinixComponent } from './component/ninix/ninix.component';
import { ImagenesPipe } from './pipe/imagenes.pipe';
import { PrendasInterfaz } from './model/prendas';

@NgModule({
  declarations: [AppComponent, ContactoComponent, ModaComponent, HomeComponent, MujerComponent, HombreComponent, NinixComponent, ImagenesPipe],
  imports: [BrowserModule, AppRoutingModule],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
