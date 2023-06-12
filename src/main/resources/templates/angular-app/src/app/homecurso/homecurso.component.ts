import { Component, Inject, OnInit } from '@angular/core';
import { CursoResponse } from 'src/interfaces/cursoResponse';
import { CarritoService } from 'src/services/carrito.service';
import { CursoService } from 'src/services/curso.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-homecurso',
  templateUrl: './homecurso.component.html',
  styleUrls: ['./homecurso.component.css']
})
export class HomecursoComponent implements OnInit {
  dataSource!:CursoResponse[];
  totalCarrito:number=0;
  constructor(private dialog: MatDialog,private cursoservicio:CursoService,
    private carritoservice:CarritoService){}
  ngOnInit(): void {
    this.obtenerDatos();
    this.obtenerContenido();
  }

  obtenerDatos() {
    this.cursoservicio.getAll().subscribe(
      (response:CursoResponse[]) => {
        console.log(response);
         this.dataSource=response;
      },
      error => {
        console.log(error);
      }
    );
  }
  agregarProductoAlCarrito(curso:CursoResponse){
    this.carritoservice.agregarProducto(curso).subscribe(c=>{
      console.log(c);
      this.dialog.open(DialogAnimationsExampleDialog, {
        width: '250px',enterAnimationDuration:"0ms",exitAnimationDuration:"0ms",data:{ message: c.message }
      });
      this.obtenerContenido();
    },error=>{
      console.log(error)
    });
    
  }
  obtenerContenido() {
this.carritoservice.obtenerContenido()
.subscribe(cursos=>{
this.totalCarrito=cursos.reduce((sum, curso) => sum + curso.precio, 0);
});
  }
  
}
@Component({
  selector: 'dialog-animations-example-dialog',
  template:`<h2 mat-dialog-title>Aviso</h2>
  <mat-dialog-content>
    <div class="error-message">
    <mat-icon class="success-icon">check_circle</mat-icon>
      <p>{{ data.message }}</p>
    </div>
  </mat-dialog-content>
  <mat-dialog-actions align="end">
    <button mat-raised-button color="primary" mat-dialog-close>OK</button>
  </mat-dialog-actions>`
})
export class DialogAnimationsExampleDialog implements OnInit {
menssage!:String;
  constructor(@Inject(MAT_DIALOG_DATA) public data: { message: string },public dialogRef: MatDialogRef<DialogAnimationsExampleDialog>) {}
  ngOnInit(): void {
      this.menssage = this.dialogRef._containerInstance._config.data;
    
  }
  onClose(): void {
    this.dialogRef.close();
  }
}

