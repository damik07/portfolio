/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Habilidades;
import com.damikportfolio.portfolio.repository.HabilidadesRepository;
import java.util.List;
import java.util.Optional;
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

    @Override
    public void actualizarHabilidades(Habilidades habil, Long id) {
        Optional<Habilidades> habils = this.habilRepo.findById(id);
        Habilidades hab = habils.get();
        
        if(!(habil.getId() == null)) {hab.setId(habil.getId());}
        if(!(habil.getNombre() == null)) {hab.setNombre(habil.getNombre());}
        if(!(habil.getLabel() == null)) {hab.setLabel(habil.getLabel());}
        if(!(habil.getData() < 0)) {hab.setData(habil.getData());}
        if(!(habil.getColor() == null)) {hab.setColor(habil.getColor());}
        
        this.habilRepo.save(hab);
                
    }
    
}
