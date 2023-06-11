package com.cibertec.request;

import java.util.List;

import lombok.Data;

@Data
public class MatriculaRequest {
	private Long idUsuario;
	private List<CursoProfesorRequest>cursos;

}
