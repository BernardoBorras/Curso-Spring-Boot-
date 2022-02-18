package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
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
        String query = "FROM Usuario";                                   // Esta linea es similar a una consulta a SQL pero es consulta a Hibernate.
       return entityManager.createQuery(query).getResultList();       // Retorname la consulta realizada a hibernate (todos los objetos de la clase usuario) 
    }                                                                 // que se almaceno en la variable query, en formato de un List de usuarios.


    


    @Override
    public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    



    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);                            // Se comunica con hibernate para solicitarle que guarde el objeto en su mapa ORM
    }





    


   // Esta funcion  verificarCredenciales()  recibe un argumento de tipo objeto.
    @Override
    public boolean verificarCredenciales(Usuario usuario){

        // Esta linea es similar a una consulta a SQL pero es consulta a Hibernate.
        String query = "FROM Usuario WHERE email = :email AND password = :password ";

        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .setParameter("password", usuario.getPassword())
                .getResultList();

        if (lista.isEmpty()){
            return false;
        }else{
            return true;
        }

    }

}

