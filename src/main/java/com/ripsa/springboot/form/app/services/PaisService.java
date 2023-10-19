package com.ripsa.springboot.form.app.services;

import java.util.List;

import com.ripsa.springboot.form.app.models.Pais;

public interface PaisService {
    
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);
}


