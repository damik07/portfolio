/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.controller;

import com.damikportfolio.portfolio.model.Educacion;
import com.damikportfolio.portfolio.service.IEducacionService;
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
public class ControllerEduc {
    
    @Autowired
    private IEducacionService educServ;
    
    //este método se puede usar tanto para agregar como para editar información
    @PostMapping ("/new/educacion")
    public void agregarEducacion (@RequestBody Educacion edu){
        educServ.crearEducacion(edu);
    }
    
    @GetMapping ("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion () {
        return educServ.verEducacion();
    }
    
    @DeleteMapping ("/delete/educacion/{id}")
    public void borrarEducacion (@PathVariable Long id){
        educServ.borrarEducacion(id);
    }
    
    @PutMapping ("actualizar/educacion/{id}")
    public void actualizarEducacion (@RequestBody Educacion educ, @PathVariable Long id){
        this.educServ.actualizarEducacion(educ, id);
    }
}
