/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damikportfolio.portfolio.repository;

import com.damikportfolio.portfolio.model.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository <Habilidades, Long>{
    
}
