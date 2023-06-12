import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { CursoService } from 'src/services/curso.service';
import { CursoProfesorDTO } from 'src/interfaces/cursoProfesorDTO';


@Component({
  selector: 'app-profesor-por-curso-component',
  templateUrl: './profesor-por-curso-component.component.html',
  styleUrls: ['./profesor-por-curso-component.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class ProfesorPorCursoComponentComponent implements OnInit{
  dataSource!: CursoProfesorDTO[];
  columnsToDisplay = ['idcurso', 'nomcurso'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement!: CursoProfesorDTO | null;
  constructor(private cursoservicio: CursoService){}
  ngOnInit(): void {
    this.obtenerDatos();
  }
  toggleExpansion(row: CursoProfesorDTO): void {
    this.expandedElement = this.expandedElement === row ? null : row;
  }
  isExpanded = (_: number, row: CursoProfesorDTO) => {
    return this.expandedElement === row;
  };
  
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
}

