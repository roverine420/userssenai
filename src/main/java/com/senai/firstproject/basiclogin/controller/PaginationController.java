package com.senai.firstproject.basiclogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginationController {

	
	@GetMapping(value="/registrar")
	public ModelAndView telaRegistro() {
		return new ModelAndView("registro");
	}
	
	@GetMapping(value="/login")
	public ModelAndView telaLogin() {
		return new ModelAndView("login");
	}
	
	@GetMapping(value="/recsenha")
	public ModelAndView telaRecSenha() {
		return new ModelAndView("recuperarSenha");
	}
}
