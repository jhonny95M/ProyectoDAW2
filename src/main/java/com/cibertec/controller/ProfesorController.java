package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cibertec.model.repository.ProfesorRepository;

@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository pRepo;
	
	@GetMapping("/cargaProf")
	public String cargarAc(Model model) {
		model.addAttribute("lstProfesores", pRepo.findAll());
		return "Profesores";
	}
}
