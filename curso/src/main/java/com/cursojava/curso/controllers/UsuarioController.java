package com.cursojava.curso.controllers;


import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    // ---------------------------------------------- Metodo para retornar usuario en formato json
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

    // ---------------------------------------------- Metodo para editar usuario
    @RequestMapping(value="editar")    //     URL

    public Usuario editar(){

        Usuario usuario = new Usuario();

        usuario.setNombre("lucas");
        usuario.setApellido("moy");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456798");
        usuario.setPassword("assas");

        return usuario;
    }

    // ---------------------------------------------- Metodo para eliminar usuario
    @RequestMapping(value="eliminar")    //     URL

    public Usuario eliminar(){

        Usuario usuario = new Usuario();

        usuario.setNombre("lucas");
        usuario.setApellido("moy");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456798");
        usuario.setPassword("assas");

        return usuario;
    }

    // ---------------------------------------------- Metodo para buscar usuario
    @RequestMapping(value="buscar")    //     URL

    public Usuario buscar(){

        Usuario usuario = new Usuario();

        usuario.setNombre("lucas");
        usuario.setApellido("moy");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456798");
        usuario.setPassword("assas");

        return usuario;
    }

}
