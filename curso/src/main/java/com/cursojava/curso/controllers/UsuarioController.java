package com.cursojava.curso.controllers;


import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    // -------------------------------------------- Metodo para retornar usuario en formato json
    @RequestMapping(value="usuarios")    //  URL

    public List<Usuario> getUsuarios(){

        List<Usuario> usuarios = new ArrayList<>(); //   +++  creamos la lista


        //-------------------------- creamos los usuarios

        Usuario usuario = new Usuario();
        usuario.setId(1L); // como id es un atribut Long, le ponems L pa q no large error
        usuario.setNombre("lucasPrueba");
        usuario.setApellido("moy");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456798");
        usuario.setPassword("assas");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombre("ras");
        usuario2.setApellido("algul");
        usuario2.setEmail("lucas@gmail.com");
        usuario2.setTelefono("123456798");
        usuario2.setPassword("assas");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3L);
        usuario3.setNombre("majula");
        usuario3.setApellido("moe");
        usuario3.setEmail("lucas@gmail.com");
        usuario3.setTelefono("123456798");
        usuario3.setPassword("assas");

        Usuario usuario4 = new Usuario();
        usuario4.setId(4L);
        usuario4.setNombre("nicolas");
        usuario4.setApellido("hoy");
        usuario4.setEmail("lucas@gmail.com");
        usuario4.setTelefono("123456798");
        usuario4.setPassword("assas");


        //------------ Añadimos a los usuarios a la lista.

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);

        return usuarios;     // ---- finaliza el metodo

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
