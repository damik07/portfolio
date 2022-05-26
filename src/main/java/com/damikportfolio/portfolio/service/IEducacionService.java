/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> verEducacion();
    public void crearEducacion (Educacion educ);
    public void borrarEducacion (Long id);
    public Educacion buscarEducacion (Long id);
    public void actualizarEducacion (Educacion educ, Long id);
    
}
