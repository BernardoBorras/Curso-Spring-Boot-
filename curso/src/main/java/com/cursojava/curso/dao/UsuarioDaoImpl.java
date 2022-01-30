package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao{  // escribimos "implements UsuarioDao" y salto erro asi que seleccionamos
    // agregar de manera automatica el metodo que indica la interface, que deberia tener esta clase. Se agrega con una anotacion
    //@Override que indica que es un metodo que esta sobreescrito (ya se encuentra en otra clase)

    @Override
    public List<Usuario> getUsuarios() {
        return null;
    }
}

// El motivo de La utilizacion de interfaces es por la utilizacion de un patron de diseño.