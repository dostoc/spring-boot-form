package com.ripsa.springboot.form.app.services;

import java.util.List;

import com.ripsa.springboot.form.app.models.Role;

public interface RoleService {

    public List<Role> listar();
    public Role obterPorId(Integer id);
    
}
