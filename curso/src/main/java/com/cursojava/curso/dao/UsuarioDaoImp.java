package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

                                                                                                // Esta clase va a tener algunas anotaciones particulares

@Repository                                                                                               // acceder al repositorio de la base de datos.
@Transactional                                                         // Le da la funcionalidad a la clase de poder armar las consultas de sql a la BD

  public class UsuarioDaoImp implements UsuarioDao{

        @PersistenceContext
        EntityManager entityManager;                                                                    // Nos va a servir para armar las consultas a la BD



      @Override
      public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";                                // Esta linea es similar a una consulta a SQL pero es consulta a Hibernate.
        return entityManager.createQuery(query).getResultList();      // Retorname la consulta realizada a hibernate (todos los objetos usuario)
      }                                                               // que se almaceno en la variable query, en formato de un List de usuarios.



      @Override
      public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
      }



      @Override
      public void registrar(Usuario usuario) {
        entityManager.merge(usuario);      // Se Comunica con hibernate, solicita que guarde el objeto en su mapa ORM
      }


    // El metodo obtenerUsuarioPorCredenciales(Usuario usuario) recibe un objeto java usuario, cuyos atributos.
    // Son los datos ingresados por el usuario al querer iniciar sesion (mail y pass).
    // Consulta a hibernate si tiene un objeto con el mismo mail. 
    // Si lo tiene, se carga en el List<>. Si no lo tiene se corta todo. Retorna null.
    // Guardamos en un String el atributo pass (hasehado) del objeto almacenado en el list<>.
    // Mediante el metodo verify() del objeto argon2, comparamos pass de usuario con pass (hasheado) del objeto del list<>.
    // Si la pasword es la misma, el metodo obtenerUsuarioPorCredenciales()  retorna el objeto del list<>


    // Antes llamado, verificarCredenciales(). Verifica las credenciales, pero en lugar de retornar un booleano. 
    // Retorna el objeto del mapa ORM, que coincide con las credenciales ingresadas. 
  

      @Override
      public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) { 

        String query = "FROM Usuario WHERE email = :email";  // Consulta a Hibernate. (usuario con ese email)

        // Armamos list de objetos. Que establece los parametros de la consulta a Hibernate.(complejo para evitar hacking)
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) {      // Si no se cargo ningun objeto (no existe en la bd) se corta todo. Retorna null. 
            return null;
        }

        // Guardamos en String, atributo Pass del objeto consultado a hibernate (pass almacenada en la bd)
        String passwordHashed = lista.get(0).getPassword();

        // Creamos una variable de tipo argon2 (es como crear un objeto de argon)
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        // Metodo verify() de argon2 Compara un hash con una pass comun. 
        // El metodo verify() se encarga de hashearla pass comun y comparar.
        // Escupe booleano.

        // Si la verificacion fue correcta retorna el primer objeto de la lista
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;
      }
  }




