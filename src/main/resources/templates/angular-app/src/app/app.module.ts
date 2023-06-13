import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { NgFor, NgIf } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { ProfesorPorCursoComponentComponent } from './profesor-por-curso-component/profesor-por-curso-component.component';
import { HttpClientModule } from '@angular/common/http';
import { NavcabeceraComponent } from './layout/navcabecera/navcabecera.component';
import { DialogAnimationsExampleDialog, HomecursoComponent } from './homecurso/homecurso.component';
import { MatDialogModule } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { GestionmatriculaComponent } from './gestionmatricula/gestionmatricula.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfesorPorCursoComponentComponent,
    NavcabeceraComponent,
    HomecursoComponent,
    DialogAnimationsExampleDialog,
    GestionmatriculaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatIconModule,
    MatTableModule,
    NgFor, 
    MatButtonModule, 
    NgIf,
    HttpClientModule,
    MatButtonModule, 
    MatDialogModule,
    CommonModule,
    MatListModule,
    MatDividerModule,
    MatSnackBarModule
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
