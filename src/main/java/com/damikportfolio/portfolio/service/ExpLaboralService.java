/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.ExpLaboral;
import com.damikportfolio.portfolio.repository.ExpLaboralRepository;
import java.util.List;
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
    
}
