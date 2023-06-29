package com.cibertec.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.model.Profesor;

import lombok.Data;

@Data
public class CursoProfesorDTO {
	
	private CursoDTO curso=new CursoDTO();
	
	private List<ProfesorDTO>profesores=new ArrayList<>(); 
	public CursoProfesorDTO(Long id, String nombre,LocalDateTime inicio,LocalDateTime fin,Profesor p) {
		curso.setIdcurso(id);
		curso.setNomcurso(nombre);
		profesores.add(new ProfesorDTO(p.getIdprof(),p.getNombresprof(),p.getApePatProf(),p.getApeMatProf(),p.getEspeprof(),inicio,fin));
	}
	public CursoProfesorDTO(Long id, String nombre) {
		curso.setIdcurso(id);
		curso.setNomcurso(nombre);
	}

}

