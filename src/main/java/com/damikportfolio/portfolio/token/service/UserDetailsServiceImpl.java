/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damikportfolio.portfolio.token.service;

import com.damikportfolio.portfolio.token.entity.UsuarioPrincipal;
import com.damikportfolio.portfolio.token.entity.Usuarioo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UsuarioService usuServ;
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuarioo usuario = usuServ.getByNombreUsuario(nombreUsuario).get();
        
        return UsuarioPrincipal.build(usuario);
    }
    
}
