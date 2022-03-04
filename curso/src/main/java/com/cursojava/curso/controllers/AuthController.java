package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController                     //  Para que la clase sea un controlador, Agegamos la anotacion.
public class AuthController {       // Clase controlador creada especificamente para verificar los inicios de sesion.

    @Autowired
    private UsuarioDao usuarioDao;   // Inyeccion de dependencias (suministramos objeto de la interface)

    @Autowired
    private JWTUtil jwtUtil;         // creamos objeto jwt

    @RequestMapping(value = "api/login", method = RequestMethod.POST) //  Metodo POST, envia informacion internamente.

    public String login(@RequestBody Usuario usuario) {

        // Creo un objeto de la clase modelo "Usuario" cuyo valores el objeto que retorna el metodo de UsuarioDaoImp.java
        // Al que le envie el objeto que recibi de la clase login.js. Y si es correcto me retorna el objeto de la BD.

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        // Si la verificacion no fue incorrecta. Almacenamos en un String. El valor que devuelve, utilizar el metodo
        // del objeto jwtUtil/"create()". El cual nos retorna el JWT si le damos: id del usuario, Email.

        if (usuarioLogueado != null){

            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            return tokenJwt;
        }
        return "FAIL";

        // Entonces el metodo loguin() de la clase AuthController.java recibe un objeto usuario.
        // De la clase loguin.js. Lo procesa. Y si es correcto, retorna un sting JWT.

    }
}

