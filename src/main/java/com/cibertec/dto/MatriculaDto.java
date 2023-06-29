package com.cibertec.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class MatriculaDto {
	private Long id;
	private LocalDateTime fechaMatricula;
	private Long user_id;
	private String nombreUsuario;
	private List<CursoDTO> cursos;

	public MatriculaDto() {

	}

	public MatriculaDto(Long id, LocalDateTime fechaMatricula, Long user_id) {

		this.id = id;
		this.fechaMatricula = fechaMatricula;
		this.user_id = user_id;
	}

	public MatriculaDto(LocalDateTime fechaMatricula, Long user_id) {

		this.fechaMatricula = fechaMatricula;
		this.user_id = user_id;
	}

	public MatriculaDto(Long id, LocalDateTime fechaMatricula, Long user_id, String name) {

		this.id = id;
		this.fechaMatricula = fechaMatricula;
		this.user_id = user_id;
		this.nombreUsuario = name;
	}

}