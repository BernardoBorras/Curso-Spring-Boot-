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
 private UsuarioDao usuarioDao;   // Inyeccion de dependencias (suministramos objeto de usuarioDaoImp)

 @Autowired
 private JWTUtil jwtUtil;         // creamos objeto jwt


    // Este metodo es invocado al iniciar sesion por loguin.js 
    // Recibe un json con los datos de inicio de sesion (lo transforma a objeto java)
    // Devuelve un string que contiene el JWT (cadena de caracteres) o un "FAIL"


    @RequestMapping(value = "api/login", method = RequestMethod.POST) //  POST, sirve para enviar informacion internamente.
    public String login(@RequestBody Usuario usuario) {  

     // loguin() recibe un json con los datos que ingreso el usuario. Y los convierte a objeto Java.  
     // Por ende, es un objeto de la clase usuario, con unicamente, atributos mail y pass. 

        // El metodo obtenerUsuarioPorCredenciales(usuario) verifica Credenciales y retorna un objeto 
        // (que proviene del mapa de hibernate) O retorna un null. Cualquiera de las 2 opciones
        // va a quedar guardada dentro de usuarioLogueado.

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario); 

        // Si la verificacion fue correcta. Creamos el jwt con el metodo del objeto jwtUtil, "create()"
        // El cual, solicita el id del usuario, Email. Este jwt creado lo almacenamos en un string. Y lo retornamos. 
        
        if (usuarioLogueado != null){

            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            return tokenJwt;
        }
        return "FAIL";

        // Entonces el metodo loguin() de la clase AuthController.java recibe un objeto usuario.
        // De la clase loguin.js. Lo procesa. Y si es correcto, retorna un sting JWT o "FAIL"

    }
}

