/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import java.util.List;
import com.damikportfolio.portfolio.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damikportfolio.portfolio.repository.PersonaRepository;
import java.util.Optional;


@Service
public class PersonaService implements IPersonaService{
    
    @Autowired    
    public PersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona pers) {
        persoRepo.save(pers);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
        
    }

    
    @Override
    public void actualizarPersona(Persona pers, Long id) {
        Optional<Persona> users = this.persoRepo.findById(id);
        Persona user = users.get();
        
        if(!(pers.getId() == null)) {user.setId(pers.getId());}
        if(!(pers.getNombre() == null)){user.setNombre(pers.getNombre());}
        if(!(pers.getApellido() == null)) {user.setApellido(pers.getApellido());}
        if(!(pers.getAcercaDe() == null)) {user.setAcercaDe(pers.getAcercaDe());}
        if(!(pers.getProfesion() == null)){user.setProfesion(pers.getProfesion());}
        if(!(pers.getResidencia() == null)) {user.setResidencia(pers.getResidencia());}
        if(!(pers.getImg_banner() == null)) {user.setImg_banner(pers.getImg_banner());}
        if(!(pers.getImg_perfil() == null)) {user.setImg_perfil(pers.getImg_perfil());}
        
        this.persoRepo.save(user);
        
    }
    
}
