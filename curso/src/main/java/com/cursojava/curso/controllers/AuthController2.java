package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


public class AuthController2 {

    @Autowired
    private UsuarioDao usuarioDao;   // Inyeccion de dependencias (suministramos objeto de usuarioDaoImp)

    @Autowired
    private JWTUtil jwtUtil;         // creamos objeto jwt

    @RequestMapping(value = "api/login", method = RequestMethod.POST) 
    public String login(@RequestBody Usuario usuario) {   

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        if (usuarioLogueado != null){

            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            return tokenJwt;
        }
        return "FAIL";
    }
    
}
