package com.ripsa.springboot.form.app.models;

import com.ripsa.springboot.form.app.validation.IdentificadorRegex;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {


    @NotBlank(message = "El USER NAME no puede estar vacio")
    @Size(min = 3, max = 8)
    private String username;

    @IdentificadorRegex
    private String password;

    @NotEmpty(message = "El email no puede estar vacio")
    @Email(message = "Correo con formato incorrecto")
    private String email;

    //VER VALIDACION UsuarioValidador
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;

    //VER VALIDACION UsuarioValidador
    private String identificador;


    public Usuario() {
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getIdentificador() {
        return identificador;
    }


    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }


}
