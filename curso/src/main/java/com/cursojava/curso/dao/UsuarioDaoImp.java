package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Esta clase va a tener algunas anotaciones particulares

@Repository  // acceder al repositorio de la base de datos.
@Transactional // le da la funcionalidad a la clase de poder armar las consultas de sql a la BD

public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;  // Nos va a servir para hacer la coneccion con la bd

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";  // Esta linea es similar a una consulta a SQL pero es consulta a Hibernate.
       return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);     // Para guardarlo en la base de datos escribimos esta linea, entityManager.merge(usuario)
    }


}

