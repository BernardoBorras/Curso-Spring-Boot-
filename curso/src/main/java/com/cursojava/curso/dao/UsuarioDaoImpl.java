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

public class UsuarioDaoImpl implements UsuarioDao{  

    @PersistenceContext
    EntityManager entityManager;  // Nos va a servir para hacer la coneccion con la bd

    @Override
    public List<Usuario> getUsuarios() {
    String query = "FROM Usuario";  // Esta linea es similar a una consulta a SQL pero es consulta a Hibernate.
       List<Usuario> resultado = entityManager.createQuery(query).getResultList();
       return resultado;
    }
    /* Con todo lo que acabamos de hacer ya estariamos hacienco la consulta a la base de datos
    *  pero en ningun momento indicamos a que tabla debe consultar. Unicamente hicimos referencia a la clase
    * ususario "FROM Usuario". Es la clase usuario, la encargada de indicar con que tabla esta relacionada.
    * */

}

