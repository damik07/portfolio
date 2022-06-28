/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damikportfolio.portfolio.token.controller;

import com.damikportfolio.portfolio.token.dto.JwtDto;
import com.damikportfolio.portfolio.token.dto.LoginUsuario;
import com.damikportfolio.portfolio.token.dto.NuevoUsuario;
import com.damikportfolio.portfolio.token.entity.Rol;
import com.damikportfolio.portfolio.token.entity.Usuarioo;
import com.damikportfolio.portfolio.token.enums.RolNombre;
import com.damikportfolio.portfolio.token.jwt.JwtProvider;
import com.damikportfolio.portfolio.token.service.RolService;
import com.damikportfolio.portfolio.token.service.UsuarioService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authManager;
    
    @Autowired
    UsuarioService usuServ;
    
    @Autowired
    RolService rolServ;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevoUsu")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o mail invalido"), HttpStatus.BAD_REQUEST);
        if(usuServ.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuServ.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        
        Usuarioo usuario = 
                new Usuarioo(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), 
                passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolServ.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolServ.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuServ.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.CREATED);
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
    @GetMapping ("/ver/usu")
    @ResponseBody
    public List<Usuarioo> verUsus () {
        return usuServ.verUsus();
    }
    
    @DeleteMapping ("/delete/usu/{id}")
    public void borrarUsu (@PathVariable Integer id){
        usuServ.borrarUsu(id);
    }
    
    
    
    
    
}
