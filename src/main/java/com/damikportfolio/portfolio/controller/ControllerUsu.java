/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.controller;

import com.damikportfolio.portfolio.model.Usuario;
import com.damikportfolio.portfolio.service.IUsuarioService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUsu {
    
    @Autowired
    private IUsuarioService usuServ;
    
    //este método se puede usar tanto para agregar como para editar información
    @PostMapping ("/new/usuario")
    public void agregarUsuario (@RequestBody Usuario usu){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usu.getPassword());
        usu.setPassword(hash);
        usuServ.crearUsuario(usu);
    }
    
    @GetMapping ("/ver/usuarios")
    @ResponseBody
    public List<Usuario> verUsuarios () {
        return usuServ.verUsuarios();
    }
    
    @DeleteMapping ("/delete/usuario/{id}")
    public void borrarUsuario (@PathVariable Long id){
        usuServ.borrarUsuario(id);
    }
    
    @PostMapping ("/usuario/Ok")
    @ResponseBody
    @SuppressWarnings("deprecation")
    public boolean usuarioOk (Usuario usu){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        List<Usuario> usuarios = usuServ.verUsuarios();
        System.out.print(usu);
        for (Usuario x:usuarios){
            System.out.print(x);
            
        }
        return false;
    }
    
}
