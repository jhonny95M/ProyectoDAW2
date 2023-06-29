export class CursoProfesorDTO {
    curso!:CursoDTO;
    profesores!: ProfesorDTO[];
  }
  
  export class ProfesorDTO {
    id!:number;
    nombresprof!: string;
    apePatprof!: string;
    apeMatProf!: string;
    espeprof!: string;
    inicio!:Date;
    fin!:Date;
    isChecked!:boolean;
  }
  export class CursoDTO {
    idcurso!: number;
    nomcurso!: string;
  }
  