/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Usuario;
import java.util.List;


public interface IUsuarioService {
    public List<Usuario> verUsuarios();
    public void crearUsuario (Usuario usu);
    public void borrarUsuario (Long id);
    public Usuario buscarUsuario (Long id);
    public Usuario loadUserByEmail(String email);
    
    
    
}
