export interface CursoProfesorDTO {
    curso:CursoDTO;
    profesores: ProfesorDTO[];
  }
  
  export interface ProfesorDTO {
    nombresprof: string;
    apePatprof: string;
    apeMatProf: string;
    espeprof: string;
    inicio:Date;
    fin:Date;
  }
  export interface CursoDTO {
    idcurso: number;
    nomcurso: string;
  }
  