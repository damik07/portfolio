/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.damikportfolio.portfolio.model;

import com.damikportfolio.portfolio.token.entity.Rol;
import com.damikportfolio.portfolio.token.enums.RolNombre;
import com.damikportfolio.portfolio.token.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreacionRoles implements CommandLineRunner{

    @Autowired
    RolService rolServ;
    
    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolServ.save(rolUser);
        rolServ.save(rolAdmin);
    }
    
}*/
