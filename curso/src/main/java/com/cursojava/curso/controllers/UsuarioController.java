package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//  Usuarios.js     Se conecta con getUsuarios()  y  eliminar()
//  Registrar.js    Se conecta con registrarUsuario()
//  Esta clase contiene los metodos
//      getUsuarios()
//      eliminar()
//      registrarUsuario() 


@RestController
public class UsuarioController {
    //  inyeccion de dependencias: @Autowired hace que la clase usuarioDaoImpl.java
    //  cree un objeto y lo guarde dentro de la variable usuarioDao, sin necesidad de hacer nada.
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    //-----------------------------------------------------------------------------------------------------------------


//                  Implementacion de JWT - parte 2.2 - verificacion del token recibido

// La funcion getUsuarios() no tenia parametros. Solo era llamada via request y retornaba 1 list de objetos usuario.
// Ahora le agregamos una estructura de parametro que nos permite guardar el String token del header de la request.
// Guardado el token, verificamos que sea correcto con el metodo de un objeto de JWTUtil, inyectado.


    @RequestMapping(value = "api/usuarios")    //  URL invocada desde usuarios.js activa la funcion
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; } // Si la validacion no dio verdadero, getUsuarios() retorna null (o lista vacia, lo mismo)
        return usuarioDao.getUsuarios();            // Caso contrario, el flujo continua y getUsuarios() retorna el list de objetos usuario.
    }




    private boolean validarToken(String token){          // El metodo recibe un token y retorna true o false.
        String usuarioId = jwtUtil.getKey(token); // Método para validar y leer el JWT, Verifica que sea un string firmado.
                                                  // si es valido retorna el id, si no lo es, arroja una excepcion.
                                                  // Si el metodo jwtUtil.getKey() arrojo excepcion usuarioId = null
        return (usuarioId != null);        // Las expresiones booleanas están hechas de operadores lógicos y de comparación.
    }                                      // Retorname el resultado de esa expresion boleana (verificacion fue correcta o incorrecta)




    //-----------------------------------------------------------------------------------------------------------------

    //  Por defectos las funciones invocadas por URL vienen con GET, especificamos que es DELETE
    @RequestMapping(value="api/usuarios/{id}",method = RequestMethod.DELETE)
    // Los parametros de la funcion eliminar son 2 estructuras, la primera, atrapa el token del header de la request.
    // La segunda atrapa/almacena el argumento (id) que envia por URL la funcion js al invocar.

    public void eliminar(@RequestHeader(value="Authorization") String token, @PathVariable long id){

        if (!validarToken(token)) { return; } // Si la validacion no dio verdadero, eliminar() retorna... ??

        usuarioDao.eliminar(id);    // Caso contrario, elimina el usuario que le solicitamos via request.

    }           // Listo, ya tenemos controlado, eliminar(), verifica que tengamos la sesion inciada.
                // luego se le pueden sumar mas cosas como, determinar que permisos tiene para eliminar ese usuario.

    //-----------------------------------------------------------------------------------------------------------------


    // Registrar usuario no requiere, verificacion de token, por que
    // recien se estaria creando un usuario. No hay una sesion iniciada.
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)  // URL de funcion que recibe el json con los datos del usuario. 
    public void registrarUsuario(@RequestBody Usuario usuario) {          // Solicitar el body recibido y convertirlo a objeto de la clase Usuario.java
                                                                          // Anotacion @RequestBody convierte el json recibido a un usuario.

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);  // Creamos un objeto de tipo Argon2 llamado argon2

        // Creamos variable de tipo string cuyo valor va a ser el resultado de la encriptacion del objeto argon2 al atributo password del objeto usuario.
        String hash = argon2.hash(1,1024,1,usuario.getPassword());   // resumen: objeto argon2 encripta atributo de objeto usuario. Y almacena en String. 

        usuario.setPassword(hash);                             // Teniendo el atributo del objeto encriptado, se lo modificamos.                       

        usuarioDao.registrar(usuario);                         // Ahora si, utilizamos el objeto usuario en la invocacion del metodo de dao/usuarioDaoImp.java 
    }

    // Mediante inyeccion utiliza el metodo registrar() de usuarioDaoImp, a travez de la variable "usuarioDao" (de su interface)
    // Metodo de registrar() recibe objeto java "usuario" y solicita a hibernate que lo guarde en su mapa ORM.
    








}
