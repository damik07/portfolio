/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Habilidades;
import java.util.List;


public interface IHabilidadesService {
    public List<Habilidades> verHabilidades();
    public void crearHabilidades (Habilidades habil);
    public void borrarHabilidades (Long id);
    public Habilidades buscarHabilidades (Long id);
    public void actualizarHabilidades (Habilidades habil, Long id);
}
