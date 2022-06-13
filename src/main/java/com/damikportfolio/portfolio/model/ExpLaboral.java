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
public class ExpLaboral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String posicion;
    private String anioDesde;
    private String anioHasta;
    @Column(name = "descripcion", columnDefinition="TEXT")
    private String descripcion;
    private String img;

    public ExpLaboral() {
    }

    public ExpLaboral(Long id, String nombre, String posicion, String anioDesde, String anioHasta, String descripcion, String img) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.anioDesde = anioDesde;
        this.anioHasta = anioHasta;
        this.descripcion = descripcion;
        this.img = img;
    }

    
    
    
    
}
