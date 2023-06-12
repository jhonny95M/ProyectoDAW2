import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CursoResponse } from 'src/interfaces/cursoResponse';
import { OkResponse } from 'src/interfaces/okResponse';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {
  private apiUrl = 'http://localhost:8081/api/cart';
  constructor(private http: HttpClient) { }
  agregarProducto(curso:CursoResponse):Observable<OkResponse> {
    return this.http.post<OkResponse>(`${this.apiUrl}/agregar`,curso,{withCredentials:true});
}
eliminarProducto(idProducto:number):Observable<OkResponse> {
  return this.http.get<OkResponse>(`${this.apiUrl}/eliminar/${idProducto}`);
}
obtenerContenido():Observable<CursoResponse[]> {
  return this.http.get<CursoResponse[]>(`${this.apiUrl}/contenido`,{withCredentials:true});
}
}
