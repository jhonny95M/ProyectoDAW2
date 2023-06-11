package com.cibertec.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.dto.ProfesorCursoDTO;
import com.cibertec.service.ProfesorService;

@RestController
@RequestMapping("/api/profesor")
public class ApiProfesorController {
	@Autowired
	private ProfesorService profesorservice;
	@GetMapping
	public ResponseEntity<List<ProfesorCursoDTO>> getAllWithCursos() {
		return new ResponseEntity<>(profesorservice.getAllProfesoresAndCursos(),HttpStatus.OK);
	}
}
