/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Proyectos;
import java.util.List;


public interface IProyectosService {
    public List<Proyectos> verProyectos();
    public void crearProyecto (Proyectos proy);
    public void borrarProyecto (Long id);
    public Proyectos buscarProyecto (Long id);
    public void actualizarProyecto (Proyectos proy, Long id);
    
}
