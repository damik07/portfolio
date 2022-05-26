/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.Proyectos;
import com.damikportfolio.portfolio.repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService{
    
    @Autowired
    public ProyectosRepository proyRepo;

    @Override
    public List<Proyectos> verProyectos() {
        return proyRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyectos proy) {
        proyRepo.save(proy);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyecto(Long id) {
        return proyRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarProyecto(Proyectos proy, Long id) {
        Optional<Proyectos> proys = this.proyRepo.findById(id);
        Proyectos proye = proys.get();
        
        if(!(proy.getId() == null)) {proye.setId(proy.getId());}
        if(!(proy.getNombre() == null)) {proye.setNombre(proy.getNombre());}
        if(!(proy.getDescripcion() == null)) {proye.setDescripcion(proy.getDescripcion());}
        if(!(proy.getFecha() == null)) {proye.setFecha(proy.getFecha());}
        if(!(proy.getLink() == null)) {proye.setLink(proy.getLink());}
        if(!(proy.getImg() == null)) {proye.setImg(proy.getImg());}
        
        this.proyRepo.save(proye);
    }
    
}
