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
public class Habilidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String label;
    private int data;
    private String color;

    public Habilidades() {
    }

    public Habilidades(Long id, String nombre, String label, int data, String color) {
        this.id = id;
        this.nombre = nombre;
        this.label = label;
        this.data = data;
        this.color = color;
    }
    
    
    
}
