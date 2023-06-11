package com.cibertec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.dto.CursoDTO;
import com.cibertec.dto.ProfesorCursoDTO;
import com.cibertec.dto.ProfesorDTO;
import com.cibertec.model.repository.ProfesorCursoRepository;

@Service
public class ProfesorService {

	@Autowired
	private ProfesorCursoRepository proCursoRepository;
	
	public List<ProfesorCursoDTO> getAllProfesoresAndCursos() {
		List<ProfesorCursoDTO>listaReturn=new ArrayList<>();
		List<ProfesorCursoDTO>profesores=proCursoRepository.findProfesorWithCursoDTOsByEstado();
		// Agrupar por edad
        Map<ProfesorDTO, List<ProfesorCursoDTO>> profesoresById = profesores.stream()
                .collect(Collectors.groupingBy(ProfesorCursoDTO::getProfesor));
        
        // Imprimir los grupos
        for (Map.Entry<ProfesorDTO, List<ProfesorCursoDTO>> entry : profesoresById.entrySet()) {
        	ProfesorDTO idcurso = entry.getKey();
            List<ProfesorCursoDTO> cursosWithId = entry.getValue();
            ProfesorCursoDTO profesor= cursosWithId.get(0);
            System.out.println("Age: " + idcurso);
            List<CursoDTO>cursos=new ArrayList<>(); 
            for (ProfesorCursoDTO item : cursosWithId) {
            	cursos.addAll(item.getCursos());
            }
            profesor.setCursos(cursos);
            listaReturn.add(profesor);
            System.out.println();
        }
		return listaReturn;
	}
}
