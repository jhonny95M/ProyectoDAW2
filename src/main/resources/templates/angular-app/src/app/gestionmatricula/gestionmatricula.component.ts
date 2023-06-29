import { Component, Inject, OnInit } from '@angular/core';
import { CursoDTO, CursoProfesorDTO, ProfesorDTO } from 'src/interfaces/cursoProfesorDTO';
import { CursoService } from 'src/services/curso.service';
import {obtenerHora} from '../common/fechas/fechas-utils'
import { matricula } from 'src/interfaces/matricula';
import { MatriculaService } from 'src/services/matricula.service';
import { cursoProfesor } from 'src/interfaces/cursoProfesor';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { DialogAnimationsExampleDialog } from '../homecurso/homecurso.component';
import { CarritoService } from 'src/services/carrito.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gestionmatricula',
  templateUrl: './gestionmatricula.component.html',
  styleUrls: ['./gestionmatricula.component.css']
})
export class GestionmatriculaComponent implements OnInit {
  constructor(private dialog: MatDialog,
    private cursoservicio: CursoService,private matriculaservice:MatriculaService,
    private carritoService:CarritoService,
    private router: Router){

  }
  dataSource!: CursoProfesorDTO[];
  ngOnInit(): void {
    this.obtenerDatos();
  }

  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    const dialogRef =this.dialog.open(DialogConfirmation, {
      width: '250px',
      enterAnimationDuration,
      exitAnimationDuration
    });
    dialogRef.afterClosed().subscribe(result => {
      if(result===true){
        this.resgistrarMatricula();
      }
    });
  }

  obtenerDatos() {
    this.carritoService.obtenerCarritoContenido().subscribe(
      (response:CursoProfesorDTO[]) => {
        console.log(response);
        if(response.length==0){
          this.router.navigate(['/angular/cursos']);
        }
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
    return diasSemana[indiceDia];
  }
  
  obtenerHora(fecha:Date| string):string{
    return obtenerHora(fecha);
  }
  resgistrarMatricula(){
    try{
      
    let request=new matricula();
    request.idUsuario=11;
    request.cursos=new Array();
    this.dataSource.forEach(element => {
      let profesoresSeleccionados = element.profesores.filter(profesor => profesor.isChecked);
      if(profesoresSeleccionados.length!=1)throw new Error("Seleccione todos los cursos.");
      let cursoProf= new cursoProfesor();
      cursoProf.idCurso=element.curso.idcurso;
      cursoProf.idProfesor=profesoresSeleccionados[0].id;
      request.cursos.push(cursoProf);
    });
    console.log(request);
    this.matriculaservice.resgistrarMatricula(request)
    .subscribe(c=>{
      this.dialog.open(DialogAnimationsExampleDialog, {
      width: '250px',enterAnimationDuration:"0ms",exitAnimationDuration:"0ms",data:{ message: "Se matriculo con exito!!!" }});
      this.router.navigate(['/angular/cursos']);
    },er=>this.dialog.open(DialogAnimationsExampleDialog, {
      width: '250px',enterAnimationDuration:"0ms",exitAnimationDuration:"0ms",data:{ message: er.error.message }
    }));
    
  }catch(error){
    this.dialog.open(DialogAnimationsExampleDialog, {
      width: '250px',enterAnimationDuration:"0ms",exitAnimationDuration:"0ms",data:{ message: error }
    })
  }
  }
  radioChanged(curso:CursoProfesorDTO,profesor: ProfesorDTO): void {
    // Lógica para manejar el cambio del input de radio
    console.log('Radio button changed:', profesor);
    // Realiza cualquier acción adicional que necesites
    curso.profesores.forEach(elemnt=>elemnt.isChecked=false);
    profesor.isChecked=true;
  }
  
}

@Component({
  selector: 'dialog-confirmation',
  template:`<h1 mat-dialog-title>Confimacion</h1>
   <mat-dialog-content>
    Desea registrar su matricula?
   </mat-dialog-content>
  <mat-dialog-actions align="end">
    <button mat-button mat-dialog-close>No</button>
    <button mat-button [mat-dialog-close]="true" cdkFocusInitial>Si</button>
  </mat-dialog-actions>`
})
export class DialogConfirmation implements OnInit {
menssage!:String;
  constructor(@Inject(MAT_DIALOG_DATA) public data: { message: string },public dialogRef: MatDialogRef<DialogConfirmation>) {}
  ngOnInit(): void {
      this.menssage = this.dialogRef._containerInstance._config.data;
    
  }
  onClose(): void {
    this.dialogRef.close();
  }
}

