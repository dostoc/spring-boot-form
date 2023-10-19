package com.ripsa.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ripsa.springboot.form.app.models.Role;

@Service
public class RoleServiceImplement implements RoleService   {

    private List<Role> roles;
    
    public RoleServiceImplement(){
        this.roles = new ArrayList<>();
        this.roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
        this.roles.add(new Role(2, "Usuario", "ROLE_USER"));
        this.roles.add(new Role(3, "Moderador", "ROLE_MOD"));
    }

    @Override
    public List<Role> listar() {
        return roles;
    }

    @Override
    public Role obterPorId(Integer id) {
        Role resultado = null;
        for (Role role : roles) {
            if(id == role.getId()){
                resultado = role;
                break;
            }
        }
        return resultado;

    }
    
}