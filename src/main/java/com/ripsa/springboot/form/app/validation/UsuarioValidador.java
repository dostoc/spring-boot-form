package com.ripsa.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ripsa.springboot.form.app.models.Usuario;

@Component
public class UsuarioValidador implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // si es asignable desde ... pregunta si la clase usuario es asignable que se esta pasando por argumento
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuario.nombre");

        // if(usuario.getNombre().isEmpty()){
        //     errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
        // }

        if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
            errors.rejectValue("identificador", "pattern.usuario.identificador");
        }
    }

    
    
}
