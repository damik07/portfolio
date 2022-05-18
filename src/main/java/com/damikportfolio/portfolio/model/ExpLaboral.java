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
public class ExpLaboral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String posicion;
    private String año_desde;
    private String año_hasta;
    private String descripcion;
    private String img;

    public ExpLaboral() {
    }

    public ExpLaboral(Long id, String nombre, String posicion, String año_desde, String año_hasta, String descripcion, String img) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.año_desde = año_desde;
        this.año_hasta = año_hasta;
        this.descripcion = descripcion;
        this.img = img;
    }
    
    
    
}
