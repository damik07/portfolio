/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damikportfolio.portfolio.token.service;

import com.damikportfolio.portfolio.token.entity.Usuarioo;
import com.damikportfolio.portfolio.token.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService implements IUsuService{
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Optional<Usuarioo> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail (String email){
        return usuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuarioo usuario){
        usuarioRepository.save(usuario);
    }
    
    
    /*public List<Usuarioo> verUsus() {
        return usuarioRepository.findAll();
    }
    
    public void borrarUsus(Integer id) {
        usuarioRepository.deleteById(id);
    }
    
    public Usuarioo buscarUsu(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }*/

    @Override
    public List<Usuarioo> verUsus() {
        return usuarioRepository.findAll();
    }

    @Override
    public void borrarUsu(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuarioo buscarUsu(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    
    
    
    
}
