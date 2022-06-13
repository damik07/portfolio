/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damikportfolio.portfolio.repository.UsuRepository;


@Service
public class UsuarioServ implements IUsuarioService{
    
    @Autowired
    public UsuRepository usuRepo;

    @Override
    public List<Usuario> verUsuarios() {
        return usuRepo.findAll();
    }

    @Override
    public void crearUsuario(Usuario usu) {
        usuRepo.save(usu);
    }

    @Override
    public void borrarUsuario(Long id) {
        usuRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return usuRepo.findById(id).orElse(null);
    }
    
    @Override
    public Usuario loadUserByEmail(String email) {
        Usuario user = usuRepo.findByEmail(email);
        return user;
    }

    

    

    

    

    

    
    
    
    
}
