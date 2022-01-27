
// Call the dataTables jQuery plugin


$(document).ready(function() {

  cargarUsuarios();
  $('#usuarios').DataTable();

});



async function cargarUsuarios() {

  const request = await fetch('usuarios', {   // Esta es la url que manda a llamar de UsuarioController.java
                                              //  la cual contiene el metodo getUsuarios() que escupe json.

    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });

  const usuarios = await request.json();

  console.log(content);

}