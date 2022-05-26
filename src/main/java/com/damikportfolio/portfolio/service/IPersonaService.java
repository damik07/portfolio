/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import java.util.List;
import com.damikportfolio.portfolio.model.Persona;


public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona (Persona pers);
    public void borrarPersona (Long id);
    public Persona buscarPersona (Long id);
    public void actualizarPersona (Persona pers, Long id);
}
