/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Habilidades;
import com.damikportfolio.portfolio.repository.HabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService implements IHabilidadesService{
    
    @Autowired
    public HabilidadesRepository habilRepo;

    @Override
    public List<Habilidades> verHabilidades() {
        return habilRepo.findAll();
    }

    @Override
    public void crearHabilidades(Habilidades habil) {
        habilRepo.save(habil);
    }

    @Override
    public void borrarHabilidades(Long id) {
        habilRepo.deleteById(id);
    }

    @Override
    public Habilidades buscarHabilidades(Long id) {
        return habilRepo.findById(id).orElse(null);
    }
    
}
