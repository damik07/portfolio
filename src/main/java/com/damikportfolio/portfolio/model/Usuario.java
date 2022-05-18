/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String usuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Boolean valido;

    public Usuario() {
    }

    public Usuario(Long id, String usuario, String email, String password, Boolean valido) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.valido = valido;
    }

    
    
    
    
    
}
