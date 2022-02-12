package com.cursojava.curso.controllers;


import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

// esta anotacion hace que la clase usuarioDaoImpl.java cree un objeto y lo guarde dentro de la variable
//  usuarioDao, sin necesidad de hacer nada.   Esto seria aplicar inyeccion de dependencias.

    @Autowired
    private UsuarioDao usuarioDao;

    // -------------------------------------------- Metodo para retornar usuarios en formato json

    @RequestMapping(value = "api/usuarios")    //  URL
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    // -------------------------------------------- Metodo para Registrar usuarios en formato json

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)    //  URL
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario);
    }

    // va a llamar a una funcion nueva llamada registrar que va a recibir como parametro un objeto de ususario
    // con la anotacion @RequestBody estariamos convirtiendo el json que recibe a un usuario automaticamente.

    // En esta funcion de la clase UsuarioController.java vamos a recibir los datos de registro de usuario que
    // se ingresesn desde el html.



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

    @RequestMapping(value="api/usuarios/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id){
    usuarioDao.eliminar(id);

    }


}
