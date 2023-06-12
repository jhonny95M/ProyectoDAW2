package com.cibertec.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.dto.CursoProfesorDTO;
import com.cibertec.response.CursoResponse;
import com.cibertec.service.CursoService;


@RestController
@RequestMapping("/api/curso")
public class ApiCursoController {
	@Autowired
	private CursoService cursoservice;
	@GetMapping("/getAllWithProfesores")
	public ResponseEntity<List<CursoProfesorDTO>> getAllWithProfesores() {
		return new ResponseEntity<>(cursoservice.getAllCursosAndProfesores(),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<CursoResponse>>getAll(){
		return new ResponseEntity<List<CursoResponse>>(cursoservice.findAll(),HttpStatus.OK);
	}

}
