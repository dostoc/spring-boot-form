package com.ripsa.springboot.form.app.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	public String tituloIndex;
	
	@GetMapping({"","/","/index"}) 
	public String index(Model model) {
		model.addAttribute("titulo", tituloIndex);
		return "index";
	}
	
	
	

}
