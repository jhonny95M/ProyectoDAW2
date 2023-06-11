package com.cibertec.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.model.Curso;

import lombok.Data;

@Data
public class ProfesorCursoDTO {
	private ProfesorDTO profesor=new ProfesorDTO();
	private List<CursoDTO>cursos=new ArrayList<>(); 
	public ProfesorCursoDTO(Long id, String nombresprof,String apePatProf,String apeMatProf,
			String special,LocalDateTime inicio,LocalDateTime fin,Curso c) {
		profesor.setId(id);
		profesor.setApePatprof(apePatProf);
		profesor.setApeMatProf(apeMatProf);
		profesor.setNombresprof(nombresprof);
		profesor.setInicio(inicio);
		profesor.setFin(fin);
		profesor.setEspeprof(special);
		cursos.add(new CursoDTO(c.getId(),c.getNomcurso()));
	}
	public ProfesorCursoDTO() {
		
	}
}
