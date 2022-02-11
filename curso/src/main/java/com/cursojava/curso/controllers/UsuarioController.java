package com.cursojava.curso.controllers;


import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

// esta anotacion hace que la clase usuarioDaoImpl.java cree un objeto y lo guarde dentro de la variable
//  usuarioDao, sin necesidad de hacer nada.   Esto seria aplicar inyeccion de dependencias.

    @Autowired
    private UsuarioDao usuarioDao;

    // -------------------------------------------- Metodo para retornar usuarios en formato json
    @RequestMapping(value = "usuarios")    //  URL
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
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
