package com.cursojava.curso.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

// Vamos a indicar Agregando anotaciones. Con que tabla de la bd esta relacionada esta clase usuario.
// Para que al consultar la clase usuario, se acceda a la tabla usuarios, pues estan relacionadas.

@Entity // Anotación que define que una clase se puede asignar a una tabla.
@Table(name = "usuarios") // Con esto la clase sabe que va a utilizar esa tabla.
@ToString @EqualsAndHashCode
// le estamos indicando que tabla estamos utilizando, pero hibernate no se da cuenta por
// si solo, que columna es por su nombre.

public class Usuario {

    @Id    // Con esto le indicamos que esta columna va a contener la llave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "password")
    private String password;

}
