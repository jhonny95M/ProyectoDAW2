package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cibertec.dto.MatriculaDto;
import com.cibertec.model.Alumno;
import com.cibertec.model.repository.AlumnoRepository;
import com.cibertec.service.MatriculaService;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @GetMapping("/matricula/consultaMatricula") 
	public String findById(Model model){
    	List<Alumno>lstModel=alumnoRepository.findAll();
    	model.addAttribute("lstALumnos", lstModel);
    	model.addAttribute("matriculaDto", null);
		return "consultaMatricula";
	}
    @GetMapping("/matricula/obtener")
    public String findById(@Param("idUsuario") long idUsuario, Model model) {
        List<MatriculaDto> matriculas = matriculaService.findMatriculaByUsuario(idUsuario);
        List<Alumno>lstModel=alumnoRepository.findAll();
    	model.addAttribute("lstALumnos", lstModel);
        if (matriculas.isEmpty()) {
            model.addAttribute("error", "No se encontró una matrícula para el ID de usuario proporcionado.");
        } else {
            model.addAttribute("matriculaDto", matriculas);
        }
        
        return "consultaMatricula";
    }
    
}
