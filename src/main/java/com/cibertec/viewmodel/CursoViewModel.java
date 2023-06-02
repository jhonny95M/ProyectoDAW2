package com.cibertec.viewmodel;

import java.util.List;

import com.cibertec.model.Profesor;

public class CursoViewModel {
	private String nomcurso;
	private List<Profesor>profesores;

	public String getNomcurso() {
		return nomcurso;
	}

	public void setNomcurso(String nomcurso) {
		this.nomcurso = nomcurso;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
}
