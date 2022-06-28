/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.damikportfolio.portfolio.token.service;

import com.damikportfolio.portfolio.token.entity.Usuarioo;
import java.util.List;

public interface IUsuService {
    public List<Usuarioo> verUsus();
    public void borrarUsu (Integer id);
    public Usuarioo buscarUsu (Integer id);
}
