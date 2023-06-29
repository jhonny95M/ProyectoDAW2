import { Component, Inject, OnInit } from '@angular/core';
import { CursoResponse } from 'src/interfaces/cursoResponse';
import { CarritoService } from 'src/services/carrito.service';
import { CursoService } from 'src/services/curso.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import { HttpErrorResponse } from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homecurso',
  templateUrl: './homecurso.component.html',
  styleUrls: ['./homecurso.component.css']
})
export class HomecursoComponent implements OnInit {
  dataSource!:CursoResponse[];
  carritosource!:CursoResponse[];
  totalCarrito:number=0;
  constructor(private dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private cursoservicio:CursoService,
    private carritoservice:CarritoService,
    private router: Router){}
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
      this._snackBar.open(c.message, "ok");      
      this.obtenerContenido();
    },(error:HttpErrorResponse)=>{
      if(error.status===400){
        console.log(error.error.message)
        console.log(error.message)
        this.dialog.open(DialogAnimationsExampleDialog, {
          width: '250px',enterAnimationDuration:"0ms",exitAnimationDuration:"0ms",data:{ message: error.error.message }
        });
      }
    });
    
  }
  obtenerContenido() {
this.carritoservice.obtenerContenido()
.subscribe(cursos=>{
  this.carritosource=cursos;
this.totalCarrito=this.carritosource.reduce((sum, curso) => sum + curso.precio, 0);
});
  }
  eliminarItemCarrito(id:number){
    this.carritoservice.eliminarProducto(id)
    .subscribe(rsp=>{
      this._snackBar.open(rsp.message, "ok");
      this.obtenerContenido();
    },(error)=>console.log(error))
  }
  gestionarMatricula(){
    this.router.navigateByUrl('/angular/gestionar-matricula',{skipLocationChange:true});
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

