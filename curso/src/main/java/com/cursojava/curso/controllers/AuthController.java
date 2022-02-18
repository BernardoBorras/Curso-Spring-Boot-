package com.cursojava.curso.controllers;

// Aca vamos a gestionar el inicio de sesion
// y todo lo que tenga que ver con la autenticacion

// creamos la request para recibir el inicio de sesion.

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //  Para que la clase sea un controlador, Agegamos la anotacion.
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    //  El metodo tambien va a ser post, ya que esta enviando la informacion internamente.
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        if (usuarioDao.verificarCredenciales(usuario)){ // Si la verificacion fue correcta
            return "ok";
        }
        return "FAIL";
    }
}
