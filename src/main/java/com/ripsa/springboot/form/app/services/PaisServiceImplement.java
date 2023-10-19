package com.ripsa.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ripsa.springboot.form.app.models.Pais;

@Service
public class PaisServiceImplement implements PaisService{

    private List<Pais> lista;

    

    public PaisServiceImplement(List<Pais> lista) {
        this.lista = Arrays.asList(
		new Pais(1, "AR", "Argentina"),
		new Pais(2, "BR", "Brasil"),
		new Pais(3, "CL", "Chile"),
		new Pais(4, "PE", "Peru"),
		new Pais(5, "PL", "Puelto Lico")
		);
    }


    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        for(Pais pais: this.lista){
            if(id == pais.getId()){
                resultado = pais;
                break;
            }
        }
        return resultado;
    }

    
}
