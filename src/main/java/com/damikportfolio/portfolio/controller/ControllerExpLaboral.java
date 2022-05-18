/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.controller;

import com.damikportfolio.portfolio.model.ExpLaboral;
import com.damikportfolio.portfolio.service.IExpLaboralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerExpLaboral {
    
    @Autowired
    private IExpLaboralService expLabServ;
    
    //este método se puede usar tanto para agregar como para editar información
    @PostMapping ("/new/expLaboral")
    public void agregarExpLaboral (@RequestBody ExpLaboral exp){
        expLabServ.crearExpLaboral(exp);
    }
    
    @GetMapping ("/ver/expLaboral")
    @ResponseBody
    public List<ExpLaboral> verExpLaboral () {
        return expLabServ.verExpLaboral();
    }
    
    @DeleteMapping ("/delete/expLaboral/{id}")
    public void borrarExpLaboral (@PathVariable Long id){
        expLabServ.borrarExpLaboral(id);
    }
    
}
