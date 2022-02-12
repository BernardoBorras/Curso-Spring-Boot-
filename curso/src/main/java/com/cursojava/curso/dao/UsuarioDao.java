package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao { // la intereface indica que metodos esta obligado a tener y utilizar la clase que la implemente.
                              // si la clase que la implemnta no tiene alguna funcion que indica la interface, salta error.
    List<Usuario> getUsuarios();

    void eliminar(long id);

    void registrar(Usuario usuario);
}
