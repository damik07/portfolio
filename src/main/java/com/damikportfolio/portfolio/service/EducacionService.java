/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Educacion;
import com.damikportfolio.portfolio.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public EducacionRepository educRepo;

    @Override
    public List<Educacion> verEducacion() {
        return educRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion educ) {
        educRepo.save(educ);
    }

    @Override
    public void borrarEducacion(Long id) {
        educRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return educRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarEducacion(Educacion educ, Long id) {
        Optional<Educacion> educs = this.educRepo.findById(id);
        Educacion educa = educs.get();
        
        if(!(educ.getId() == null)){educa.setId(educ.getId());}
        if(!(educ.getDescripcion() == null)){educa.setDescripcion(educ.getDescripcion());}
        if(!(educ.getTitulo() == null)){educa.setTitulo(educ.getTitulo());}
        if(!(educ.getUniversidad() == null)) {educa.setUniversidad(educ.getUniversidad());}
        if(!(educ.getPeriodo_desde() == null)) {educa.setPeriodo_desde(educ.getPeriodo_desde());}
        if(!(educ.getPeriodo_hasta() == null)) {educa.setPeriodo_hasta(educ.getPeriodo_hasta());}
        if(!(educ.getImg() == null)) {educa.setImg(educ.getImg());}
        
        this.educRepo.save(educa);
    }
    
}
