package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//      getUsuarios()
//      eliminar()
//      registrarUsuario() 


@RestController
public class UsuarioController {






    //  inyeccion de dependencias: Esto seria aplicarla. @Autowired hace que la clase usuarioDaoImpl.java
    //  cree un objeto y lo guarde dentro de la variable usuarioDao, sin necesidad de hacer nada.
    
    @Autowired
    private UsuarioDao usuarioDao;
                                               
    @RequestMapping(value = "api/usuarios")    //  URL invocada desde usuarios.js activa la funcion
    public List<Usuario> getUsuarios() {       //  Funcion que retorna un list de objetos usuario 
        return usuarioDao.getUsuarios();       // Variable de interface usuarioDao utiliza el metodo getUsuarios()
    }






    //                                                                            Por defectos las funciones invocadas por URL
    @RequestMapping(value="api/usuarios/{id}",method = RequestMethod.DELETE)  //  vienen con get, especificamos que es DELETE
    public void eliminar(@PathVariable long id){  // La funcion invocada por URL eliminar, recibe un argumento de tipo long. 
        usuarioDao.eliminar(id);
    }
    



    
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


}
