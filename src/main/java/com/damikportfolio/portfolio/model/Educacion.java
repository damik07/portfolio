/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String universidad;
    private String periodo_desde;
    private String periodo_hasta;
    private String descripcion;
    private String img;

    public Educacion() {
    }

    public Educacion(Long id, String titulo, String universidad, String periodo_desde, String periodo_hasta, String descripcion, String img) {
        this.id = id;
        this.titulo = titulo;
        this.universidad = universidad;
        this.periodo_desde = periodo_desde;
        this.periodo_hasta = periodo_hasta;
        this.descripcion = descripcion;
        this.img = img;
    }
    
    
    
    
}
