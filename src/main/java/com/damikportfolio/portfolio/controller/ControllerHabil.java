/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.controller;

import com.damikportfolio.portfolio.model.Habilidades;
import com.damikportfolio.portfolio.service.IHabilidadesService;
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
public class ControllerHabil {
    
    @Autowired
    private IHabilidadesService habilServ;
    
    //este método se puede usar tanto para agregar como para editar información
    @PostMapping ("/new/habilidad")
    public void agregarHabilidad (@RequestBody Habilidades habil){
        habilServ.crearHabilidades(habil);
    }
    
    @GetMapping ("/auth/ver/habilidades")
    @ResponseBody
    public List<Habilidades> verHabilidades () {
        return habilServ.verHabilidades();
    }
    
    @DeleteMapping ("/delete/habilidades/{id}")
    public void borrarHabilidades (@PathVariable Long id){
        habilServ.borrarHabilidades(id);
    }
    
    @PutMapping ("/actualizar/habilidades/{id}")
    public void actualizarHabilidades (@RequestBody Habilidades habil, @PathVariable Long id){
        this.habilServ.actualizarHabilidades(habil, id);
    }
}
