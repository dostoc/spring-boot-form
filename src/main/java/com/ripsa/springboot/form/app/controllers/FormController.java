package com.ripsa.springboot.form.app.controllers;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ripsa.springboot.form.app.editors.PaisPropertyEditor;
import com.ripsa.springboot.form.app.models.Pais;
import com.ripsa.springboot.form.app.models.Role;
import com.ripsa.springboot.form.app.models.Usuario;
import com.ripsa.springboot.form.app.services.PaisService;
import com.ripsa.springboot.form.app.services.RoleService;
import com.ripsa.springboot.form.app.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario") // ** se utiliza para al procesar el objeto y pasar a vista resultado este no se pase null
public class FormController {

	private static final Map<String, String> HashMap = null;

	@Autowired
	private PaisService paisService;

	@Autowired
	private PaisPropertyEditor paisEditor;

	@Autowired // **
	private UsuarioValidador validador; // **

	@Autowired
	private RoleService roleService;

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
	
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
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

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises(){
		return paisService.listar();
	}

	
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("Argentina","Brasil","Peru","Chile");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap(){
		Map<String, String> paisesMap = new HashMap<String, String>();
		paisesMap.put("AR", "Argentina");
		paisesMap.put("BR", "Brasil");
		paisesMap.put("PE", "Peru");
		paisesMap.put("CL", "Chile");
		return paisesMap;
		
	}

	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}


	@ModelAttribute("listaRolesString")
	public List<String>listaRolesString(){
		List<String> listaRoles = new ArrayList<>();
		listaRoles.add("ROLE_ADMIN");
		listaRoles.add("ROLE_USER");
		listaRoles.add("ROLE_MODERATOR");
		return listaRoles;
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String, String> usuariosMap(){
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");
		return roles;
	}


}
