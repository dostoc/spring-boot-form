package com.ripsa.springboot.form.app.controllers;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ripsa.springboot.form.app.models.Usuario;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario") // se utiliza para al procesar el objeto y pasar a vista resultado este no se pase null
public class FormController {

	@Value("${texto.formcontroller.form.titulo}")
	public String tituloform;

	@Value("${texto.formcontroller.respuestaform.titulo}")
	public String respuestaform;

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jhon");
		usuario.setApellido("Doe");
		usuario.setIdentificador("28.777.225-D");
		model.addAttribute("titulo", tituloform);
		model.addAttribute("usuario",usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status	) {
			
		model.addAttribute("titulo", respuestaform);

		if(result.hasErrors()){
			return "form";
		}

		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
