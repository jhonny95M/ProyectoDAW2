package com.cibertec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.dto.CursoDTO;
import com.cibertec.dto.CursoProfesorDTO;
import com.cibertec.dto.ProfesorDTO;
import com.cibertec.model.repository.ProfesorCursoRepository;

@Service
public class CursoService {

	@Autowired
	private ProfesorCursoRepository proCursoRepository;
	public List<CursoProfesorDTO> getAllCursosAndProfesores() {
		List<CursoProfesorDTO>listaReturn=new ArrayList<>();
		List<CursoProfesorDTO>cursos=proCursoRepository.findCursoProfesorDTOsByEstado();
		// Agrupar por edad
        Map<CursoDTO, List<CursoProfesorDTO>> cursosById = cursos.stream()
                .collect(Collectors.groupingBy(CursoProfesorDTO::getCurso));
        
        // Imprimir los grupos
        for (Map.Entry<CursoDTO, List<CursoProfesorDTO>> entry : cursosById.entrySet()) {
        	CursoDTO idcurso = entry.getKey();
            List<CursoProfesorDTO> cursosWithId = entry.getValue();
            CursoProfesorDTO curso= cursosWithId.get(0);
            System.out.println("Age: " + idcurso);
            List<ProfesorDTO>profesores=new ArrayList<>(); 
            for (CursoProfesorDTO item : cursosWithId) {
                System.out.println(curso.getCurso().getNomcurso());
                profesores.addAll(item.getProfesores());
            }
            curso.setProfesores(profesores);
            listaReturn.add(curso);
            System.out.println();
        }
		return listaReturn;
	}

}
