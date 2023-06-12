package com.cibertec.api.controller;


import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.request.MatriculaRequest;
import com.cibertec.service.MatriculaService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/matricula")
public class ApiMatriculaController {
	@Autowired
	private MatriculaService matriculaService;
	@PostMapping
	public ResponseEntity<MatriculaRequest> ResgistrarMatricula(@RequestBody MatriculaRequest request) throws ValidationException, NotFoundException {
		matriculaService.ResgistrarMatricula(request);
		return new ResponseEntity<>(request,HttpStatus.OK);
	}
}
