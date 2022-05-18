/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Educacion;
import com.damikportfolio.portfolio.repository.EducacionRepository;
import java.util.List;
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
    
}
