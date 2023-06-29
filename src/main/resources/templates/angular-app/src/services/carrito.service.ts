import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CursoProfesorDTO } from 'src/interfaces/cursoProfesorDTO';
import { CursoResponse } from 'src/interfaces/cursoResponse';
import { OkResponse } from 'src/interfaces/okResponse';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {
  private apiUrl = `${window.location.origin}/api/cart`;
  constructor(private http: HttpClient) { }
  agregarProducto(curso:CursoResponse):Observable<OkResponse> {
    return this.http.post<OkResponse>(`${this.apiUrl}/agregar`,curso,{withCredentials:true});
}
eliminarProducto(idProducto:number):Observable<OkResponse> {
  return this.http.delete<OkResponse>(`${this.apiUrl}/eliminar/${idProducto}`,{withCredentials:true});
}
obtenerContenido():Observable<CursoResponse[]> {
  return this.http.get<CursoResponse[]>(`${this.apiUrl}/contenido`,{withCredentials:true});
}
obtenerCarritoContenido():Observable<CursoProfesorDTO[]>{
  return this.http.get<CursoProfesorDTO[]>(`${this.apiUrl}/contenidoMatricula`,{withCredentials:true})
}
}
