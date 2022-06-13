/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String profesion;
    private String residencia;
    @Column(name = "acercaDe", columnDefinition="TEXT")
    private String acercaDe;
    private String img_banner;
    private String img_perfil;
    
    

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String profesion, String residencia, String acercaDe, String img_banner, String img_perfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.residencia = residencia;
        this.acercaDe = acercaDe;
        this.img_banner = img_banner;
        this.img_perfil = img_perfil;
    }

    

    

    
    
    
    
}
