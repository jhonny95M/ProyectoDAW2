import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CursoProfesorDTO } from 'src/interfaces/cursoProfesorDTO';
import { CursoResponse } from 'src/interfaces/cursoResponse';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  constructor(private http: HttpClient) { }
  getAllWithProfesores():Observable<CursoProfesorDTO[]>{
    return this.http.get<CursoProfesorDTO[]>('http://localhost:8081/api/curso/getAllWithProfesores');
  }
  getAll():Observable<CursoResponse[]>{
    return this.http.get<CursoResponse[]>('http://localhost:8081/api/curso');
  }
}
