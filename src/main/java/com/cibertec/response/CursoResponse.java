package com.cibertec.response;

import lombok.Data;

@Data
public class CursoResponse {
	private Long id;
	private String nomcurso;
	private String urlImage;
	private String descripcionCurso;
	private double precio;
	public CursoResponse(Long id, String nomcurso, String urlImage, String descripcionCurso, double precio) {
		this.id = id;
		this.nomcurso = nomcurso;
		this.urlImage = urlImage;
		this.descripcionCurso = descripcionCurso;
		this.precio = precio;
	}
	

}
