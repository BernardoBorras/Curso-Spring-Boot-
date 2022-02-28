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







    @Override
    public boolean verificarCredenciales(Usuario usuario){

        String query = "FROM Usuario WHERE email = :email";  // Consulta a Hibernate. (usuario con ese email)

        // Armamos el list de objetos. Que establece los parametros de la consulta a Hibernate.
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return false;
        }

        // Guardamos en un String el atributo Password del objeto consultado a hibernate (pass almacenada en la bd)
        String passwordHashed = lista.get(0).getPassword();

        // Creamos una variable de tipo argon2 (es como crear un objeto de argon)
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        // Metodo verify() Compara un hash (consulta a hibernate)con una contraseña ingresada(objeto usuario).
        // Si bien esta ultima no esta hasheada el metodo verify() se encarga de hashearla y comparar.
        // Como resultado, escupe valor booleano.

        boolean lapasswordEsLaMisma = argon2.verify(passwordHashed, usuario.getPassword());

        return lapasswordEsLaMisma;
    }

    // Entonces: El metodo verificarCredenciales(Usuario usuario) recibe un objeto java cuyos atributos.
    // Son los datos ingresados por el usuario al querer iniciar sesion (mail y pass).
    // Lo compara con el atributo pass del objeto consultado a hibernate (por su e-mail).
    // mediante el metodo verify() del objeto argon2.
    // Y retorna el boleano "lapasswordEsLaMisma"
}

