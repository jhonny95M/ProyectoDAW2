package com.cibertec.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.dto.CursoDTO;
import com.cibertec.model.Curso;
import com.cibertec.model.Horario;
import com.cibertec.model.Matricula;
import com.cibertec.model.ProfesorCurso;
import com.cibertec.model.User;
import com.cibertec.model.repository.MatriculaRepository;
import com.cibertec.model.repository.ProfesorCursoRepository;
import com.cibertec.model.repository.UserRepository;
import com.cibertec.request.CursoProfesorRequest;
import com.cibertec.request.MatriculaRequest;

import javassist.NotFoundException;

@Service
public class MatriculaService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MatriculaRepository matriculaRepository;
	@Autowired
	private ProfesorCursoRepository profesorCursoRepository;

	@Transactional
	public int ResgistrarMatricula(MatriculaRequest request) throws NotFoundException, ValidationException {
		// Obtener el usuario correspondiente a la matrícula
        User usuario = userRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario"));

		// Crear una lista para almacenar los cursos seleccionados
        List<Curso> cursos = new ArrayList<>();
        List<Horario> horarios = new ArrayList<>();
		for (CursoProfesorRequest item : request.getCursos()) {

			// Obtener el profesorCurso curso correspondiente a la matrícula
			ProfesorCurso profesorCurso = profesorCursoRepository
					.findByCursoAndProfesor(item.getIdCurso(),item.getIdProfesor()).orElseThrow(() -> new NotFoundException("No se encontró el profesor curso"));
			// Validar que el profesor curso tenga al menos un horario

			if (profesorCurso.getHorarios().isEmpty()) {
				throw new ValidationException("El profesor "+profesorCurso.getProfesor().getNombresprof()+" del curso "+profesorCurso.getCurso().getNomcurso()+" no tiene horarios disponibles");
			}
			horarios.addAll(profesorCurso.getHorarios());
			 // Agregar el profesor curso a la lista de cursos
            cursos.add(profesorCurso.getCurso());
		}
		if(hayCruceHorarios(horarios))
			throw new ValidationException("Existe cruce de horarios entre los cursos seleccionados");
        
		
		

		Matricula matricula = new Matricula();
		matricula.setFechmat(LocalDateTime.now());
		matricula.setCursos(cursos);
		matricula.setUsuario(usuario);

		// Guardar la matrícula
		matriculaRepository.save(matricula);
		return 1;
	}
	private boolean hayCruceHorarios(List<Horario> horarios) {        
        // Verificar si hay cruces de horarios
        for (int i = 0; i < horarios.size(); i++) {
            for (int j = i + 1; j < horarios.size(); j++) {
                if (hayCruceHorario(horarios.get(i), horarios.get(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hayCruceHorario(Horario horario1, Horario horario2) {
        LocalDateTime inicio1 = horario1.getInicio();
        LocalDateTime fin1 = horario1.getFin();
        LocalDateTime inicio2 = horario2.getInicio();
        LocalDateTime fin2 = horario2.getFin();

        return (inicio1.isBefore(fin2) && fin1.isAfter(inicio2)) || (inicio2.isBefore(fin1) && fin2.isAfter(inicio1));
    }
    public List<com.cibertec.dto.MatriculaDto>findMatriculaByUsuario(long id){
    	List<com.cibertec.dto.MatriculaDto>listado=new ArrayList<>();
    	List<Matricula>matriculas= matriculaRepository.findUsuarioById(id);
    	for (Matricula m : matriculas) {
    		com.cibertec.dto.MatriculaDto ma=new com.cibertec.dto.MatriculaDto(m.getId(), m.getFechmat(),m.getUsuario().getId(),m.getUsuario().getAlumno().getNomalum());
    		List<Curso>cursos=m.getCursos();
    		List<CursoDTO>cursosdto=new ArrayList<>();
    		for (Curso curso : cursos) {
				cursosdto.add(new CursoDTO(curso.getId(), curso.getNomcurso()));
			}
    		ma.setCursos(cursosdto);
			listado.add(ma);
		}
    	return listado;
    }

}
