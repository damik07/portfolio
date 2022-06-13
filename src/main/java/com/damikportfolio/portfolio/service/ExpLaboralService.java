/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.ExpLaboral;
import com.damikportfolio.portfolio.repository.ExpLaboralRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExpLaboralService implements IExpLaboralService{
    
    @Autowired
    public ExpLaboralRepository expLabRepo;

    @Override
    public List<ExpLaboral> verExpLaboral() {
        return expLabRepo.findAll();
    }

    @Override
    public void crearExpLaboral(ExpLaboral expLab) {
        expLabRepo.save(expLab);
    }

    @Override
    public void borrarExpLaboral(Long id) {
        expLabRepo.deleteById(id);
    }

    @Override
    public ExpLaboral buscarExpLaboral(Long id) {
        return expLabRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarExpLaboral(ExpLaboral expLab, Long id) {
        Optional<ExpLaboral> exps = this.expLabRepo.findById(id);
        ExpLaboral exp = exps.get();
        
        if(!(expLab.getId() == null)) {exp.setId(expLab.getId());}
        if(!(expLab.getNombre() == null)) {exp.setNombre(expLab.getNombre());}
        if(!(expLab.getPosicion() == null)) {exp.setPosicion(expLab.getPosicion());}
        if(!(expLab.getDescripcion() == null)) {exp.setDescripcion(expLab.getDescripcion());}
        if(!(expLab.getAnioDesde() == null)) {exp.setAnioDesde(expLab.getAnioDesde());}
        if(!(expLab.getAnioHasta() == null)) {exp.setAnioHasta(expLab.getAnioHasta());}
        if(!(expLab.getImg() == null)) {exp.setImg(expLab.getImg());}
        
        this.expLabRepo.save(exp);
    }
    
}
