package com.ripsa.springboot.form.app.models;

import java.util.Date;

import com.ripsa.springboot.form.app.validation.IdentificadorRegex;
import com.ripsa.springboot.form.app.validation.Requerido;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Usuario {


    @NotBlank(message = "El USER NAME no puede estar vacio")
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty(message = "El email no puede estar vacio")
    @Email(message = "Correo con formato incorrecto")
    private String email;

    //VER VALIDACION UsuarioValidador
    @Requerido
    private String nombre;

    //@NotEmpty(message = "El apellido no puede estar vacio")
    @Requerido
    private String apellido;

    @IdentificadorRegex //validacion personalizada
    private String identificador;

    @NotNull
    @Min(1000)
    @Max(9999)
    private Integer cuenta;

    @NotNull
    @Past
    private Date fechaNacimiento;

    @NotEmpty
    private String pais;

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


    public Integer getCuenta() {
        return cuenta;
    }


    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }


    


}
