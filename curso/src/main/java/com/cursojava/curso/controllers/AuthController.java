package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController                     //  Para que la clase sea un controlador, Agegamos la anotacion.
public class AuthController {       // Clase controlador creada especificamente para verificar los inicios de sesion.

    @Autowired
    private UsuarioDao usuarioDao;

    //  El metodo es post, por que envia informacion internamente.
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        if (usuarioDao.verificarCredenciales(usuario)){    //Si la verificacion fue correcta
            return "OK";
        }
        return "FAIL";
    }
}
