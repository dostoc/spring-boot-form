package com.ripsa.springboot.form.app.validation;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // ESTO --> value.isEmpty() || value.isBlank() se puede usar por el StringUtils (Si es distinto de vacio y si tiene espacio en blanco) hay que invertirlo porque da false por defecto por salida
        if(value == null || !StringUtils.hasText(value)){
            return false;
        }
        return true;
    }

    
}
