import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { matricula } from 'src/interfaces/matricula';

@Injectable({
  providedIn: 'root'
})
export class MatriculaService {
  apiUrl:string=`${window.location.origin}/api/matricula`;
  constructor(private http: HttpClient) { }
  resgistrarMatricula(request:matricula){
    return this.http.post<any>(`${this.apiUrl}`,request,{withCredentials:true});
  }
}
