import { Component, OnInit } from '@angular/core';
import { CursoProfesorDTO } from 'src/interfaces/cursoProfesorDTO';
import { CursoService } from 'src/services/curso.service';
import {obtenerHora} from '../common/fechas/fechas-utils'

@Component({
  selector: 'app-gestionmatricula',
  templateUrl: './gestionmatricula.component.html',
  styleUrls: ['./gestionmatricula.component.css']
})
export class GestionmatriculaComponent implements OnInit {
  constructor(private cursoservicio: CursoService){

  }
  ngOnInit(): void {
    this,this.obtenerDatos();
  }
  dataSource!: CursoProfesorDTO[];
  obtenerDatos() {
    this.cursoservicio.getAllWithProfesores().subscribe(
      (response:CursoProfesorDTO[]) => {
        console.log(response);
         this.dataSource=response;
      },
      error => {
        console.log(error);
      }
    );
  }
  obtenerNombresDias(fechaString: string | Date | null): string {
    if(fechaString == null)return "";
    const diasSemana = [
      'Domingo',
      'Lunes',
      'Martes',
      'Miércoles',
      'Jueves',
      'Viernes',
      'Sábado'
    ];
    const fecha = new Date(fechaString);
    let indiceDia = fecha.getDay();
    
    // Si quieres obtener los nombres abreviados de los días, puedes usar:
    // const diasSemanaAbreviados = ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'];
    
    // Obtener el nombre del día de la semana en español
    return diasSemana[indiceDia];
  }
  
  obtenerHora(fecha:Date| string):string{
    return obtenerHora(fecha);
  }
  
}
