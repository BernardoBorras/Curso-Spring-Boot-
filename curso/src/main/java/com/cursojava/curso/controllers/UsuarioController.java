package com.cursojava.curso.controllers;


import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;






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
        usuarioDao.registrar(usuario);                                    // Anotacion @RequestBody convierte el json recibido a un usuario.
    }

    // Mediante inyeccion utiliza el metodo registrar() de usuarioDaoImp, a travez de la variable usuarioDao (de su interface)
    // Metodo de usuarioDaoImp recibe objeto java y le solicita a hibernate que lo guarde en su mapa ORM.
    



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
