package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

// package dao :

// Esta clase es intereface: indica que metodos esta obligado a tener y utilizar la clase que la implemente.
// si la clase que la implemnta no tiene alguna funcion que indica la interface, salta error.

// Crear un objeto de la clase UsuarioDao (interface) es crear un objeto que va a contener los metodos.
// de la interface. Entonces. Si ese objeto, en la clase que es creado. Invoca su metodo getUsuarios()
// el metodo getUsuarios() consulta a hibernate todos los objetos de la clase Usuario.java. 


public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(long id);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);

}
