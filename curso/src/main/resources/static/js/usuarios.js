// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});


async function cargarUsuarios() {
  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

const usuarios = await request.json(); // const creada en esta clase, almacena el json con todos los datos de los objetos.




let listadoHtml='';   // Listado vacio al que se le van a ir cargando usuarios a medida que recorramos el json

  for (let usuario of usuarios){

    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>213</td><td>'+usuario.nombre+' '+usuario.nombre+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>' + botonEliminar + '</td></tr>'

    listadoHtml += usuarioHtml;

    console.log(usuario)
  }

document.querySelector('#usuarios tbody').outerHTML = listadoHtml;  // el error estaba en escribir outher/outer

}

function eliminarUsuario(id) {
alert(id);
}








