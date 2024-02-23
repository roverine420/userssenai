package com.senai.firstproject.basiclogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	
	@GetMapping(value="/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@GetMapping(value="/index")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
}
