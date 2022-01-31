package com.cursojava.curso.models;


import javax.persistence.Entity;
import javax.persistence.Table;

// Vamos a indicar con que tabla de la base de datos esta relacionada esta clase usuario.
// Agregando anotaciones vamos a indicarle a esta clase , con que tabla esta relacionada.

@Entity // Anotación que define que una clase se puede asignar a una tabla.
@Table(name = "usuarios") // Con esto la clase sabe que va a utilizar esa tabla.
public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
