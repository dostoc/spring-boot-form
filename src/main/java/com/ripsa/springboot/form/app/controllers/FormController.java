package com.ripsa.springboot.form.app.controllers;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ripsa.springboot.form.app.editors.NombreMayusculaEditor;
import com.ripsa.springboot.form.app.models.Usuario;
import com.ripsa.springboot.form.app.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario") // ** se utiliza para al procesar el objeto y pasar a vista resultado este no se pase null
public class FormController {

	@Autowired // **
	private UsuarioValidador validador; // **

	// ** Lo que hace esto es implementar de forma directa en el batifondo de Spring los validadores.
	// ** ver que se usa addValidator para que "sume las nuevas reglas de validacion puestas en la clase UsuarioValidator"
	// ** por eso se comenta la linea validator.validate(..) ya que esta implementado a travez del bind 
	@InitBinder 
	public void InitBinder(WebDataBinder binder){
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); // false Extricto true Tolerante 
		binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateFormat, true)); // es como un filtro - vamos a convertir un strin a un tipo date
	
		binder.registerCustomEditor(String.class,"apellido",new NombreMayusculaEditor());
	}

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

	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("Argentina","Brasil","Peru","Chile");
	}




}
