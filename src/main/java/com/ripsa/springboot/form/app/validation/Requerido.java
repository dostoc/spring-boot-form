package com.ripsa.springboot.form.app.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Constraint(validatedBy = RequeridoValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Requerido {

    public abstract java.lang.String message() default "Campo OBLIGATORIO - usando anotaciones";
  
    public abstract  java.lang.Class<?>[] groups() default {};
    
    public abstract  java.lang.Class<? extends jakarta.validation.Payload>[] payload() default {};
    
}
