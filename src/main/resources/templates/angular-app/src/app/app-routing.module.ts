import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfesorPorCursoComponentComponent } from './profesor-por-curso-component/profesor-por-curso-component.component';
import { HomecursoComponent } from './homecurso/homecurso.component';

const routes: Routes = [
  {path:'angular',component:HomecursoComponent},
  {path:'angular/cursos',component:HomecursoComponent},
  { path: 'angular/angular', component: ProfesorPorCursoComponentComponent }	
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
