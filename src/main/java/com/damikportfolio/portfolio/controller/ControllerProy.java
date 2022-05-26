/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.controller;

import com.damikportfolio.portfolio.model.Proyectos;
import com.damikportfolio.portfolio.service.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProy {
    
    @Autowired
    private IProyectosService proyServ;
    
    //este método se puede usar tanto para agregar como para editar información
    @PostMapping ("/new/proyecto")
    public void agregarProyecto (@RequestBody Proyectos proy){
        proyServ.crearProyecto(proy);
    }
    
    @GetMapping ("/ver/proyectos")
    @ResponseBody
    public List<Proyectos> verProyectos () {
        return proyServ.verProyectos();
    }
    
    @DeleteMapping ("/delete/proyecto/{id}")
    public void borrarProyectos (@PathVariable Long id){
        proyServ.borrarProyecto(id);
    }
    
    @PutMapping ("/actualizar/proyecto/{id}")
    public void actualizarProyecto (@RequestBody Proyectos proy, @PathVariable Long id){
        this.proyServ.actualizarProyecto(proy, id);
    }
    
}
