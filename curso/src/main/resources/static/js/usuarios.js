
// Call the dataTables jQuery plugin
// Esto es una libreria de js

// esta funcion hace que se ejecute todo lo que esta
// denmtro de ella al segundo de estar cargandose la pagina.
// Si ponemos una alaerta, va a mostrarla como primera accion
// luego muestra la pagina.

$(document).ready(function() {

  cargarUsuarios();
  $('#usuarios').DataTable();

});

// que lo qu hace es seleccionar el elemento
// con el tag #database y ponerle esta funcionalidad
// .DataTable();   de convertir en una tabla que tenga
//  paginacion y un monton de funcionalidades

async function cargarUsuarios() {

  const request = await fetch('usuario/234', {  // usuario/234 es la url de la funcion
                                                    // getUsuario() que se encuentra en
                                                    // UsusarioController.java. Enencargada
                                                    // de devolvernos un json con los datos
                                                    // del usuario. Lo que estamos haciendo
                                                    // con esto es recibir esos datos desde
                                                    // el back end y mostrarlos a travez de
                                                    // una funcion .js en el usuarios.html
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });

  const usuarios = await request.json();

  console.log(content);

}