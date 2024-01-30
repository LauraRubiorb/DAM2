import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConcesionarioComponent } from './components/concesionario/concesionario.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, ConcesionarioComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
