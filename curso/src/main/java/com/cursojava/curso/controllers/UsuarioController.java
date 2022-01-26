package com.cursojava.curso.controllers;


import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {


    @RequestMapping(value="usuario")    //     URL

    public Usuario getUsuario(){

        Usuario usuario = new Usuario();

        usuario.setNombre("lucas");
        usuario.setApellido("moy");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456798");
        usuario.setPassword("assas");

        return usuario;
    }

}
