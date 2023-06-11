export interface CursoProfesorDTO {
    curso:CursoDTO;
    profesores: ProfesorDTO[];
  }
  
  export interface ProfesorDTO {
    nomprof: string;
    apeprof: string;
    espeprof: string;
  }
  export interface CursoDTO {
    idcurso: number;
    nomcurso: string;
  }
  