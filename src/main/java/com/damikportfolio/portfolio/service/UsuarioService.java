/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Usuario;
import com.damikportfolio.portfolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    public UsuarioRepository usuRepo;

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
