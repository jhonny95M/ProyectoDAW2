package com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cibertec.model.Alumno;

@Controller
public class AuthenticateController {

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "Login";
	}
}
