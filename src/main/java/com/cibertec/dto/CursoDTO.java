package com.cibertec.dto;

import lombok.Data;

@Data
public class CursoDTO {
	
	public CursoDTO(Long idcurso2, String nomcurso2) {
		idcurso=idcurso2;
		nomcurso=nomcurso2;
	}
	public CursoDTO() {
	}
	private Long idcurso;
	private String nomcurso;
}
