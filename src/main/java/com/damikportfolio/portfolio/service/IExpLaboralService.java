/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.service;

import com.damikportfolio.portfolio.model.ExpLaboral;
import java.util.List;


public interface IExpLaboralService {
    public List<ExpLaboral> verExpLaboral();
    public void crearExpLaboral (ExpLaboral expLab);
    public void borrarExpLaboral (Long id);
    public ExpLaboral buscarExpLaboral (Long id);
    
}
