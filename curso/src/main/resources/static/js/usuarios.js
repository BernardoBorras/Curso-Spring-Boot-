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

// constante que almacena el json con los datos de todos los usuarios. Transforma a json.
const usuarios = await request.json();





let listadoHtml='';    

  for (let usuario of usuarios){    

    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
  
    let usuarioHtml = '<tr><td>213</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'+usuario.password+'</td><td>' + botonEliminar + '</td></tr>'

    listadoHtml += usuarioHtml;   

    console.log(usuario)     
  }

document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}


// 23: Listado vacio que va ir recibiendo usuarios del bucle for
// 25: recorre la variable ususarios que contiene el json con los datos de todos los usuarios.
// 39: en la primer vuelta lee el primer registro del json y crea html de manera dinamica. Html con la estructura que lleva ususarios.html
// 31: ese html dinamico se almaceno en usuarioHtml. Lo sumamos a la bariable alojada fuera del bucle listadoHtml
// 33: en cada vuelta del bucle se va a imprimir en consola, que usuario del json que contiene usuarios. Estamos recorriendo.
// 36: Luego de haber cargado la variable listadoHtml con todo el html diamico necesario (todos los usuarios). Lo insertamos en usuarios.html



async function eliminarUsuario(id) {

  if (!confirm('¿Desea eliminar este usuario?')){ return; }

  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload()
}

// 51: Funcion eliminarUsuario() se activa cuando se apreta cualquiera de los botones creados en la linea 31.
//     al ser activada se envia el (argumento = identificador de cada usuario)
// 55: Poner un if al principio de la funcion eliminarUsuario() nos permite cortar el flujo de la funcion
//     en este caso lo invertimos poniendo ! al principio. Si ponemos NO, corta el flujo de la funcion. 
//     si ponemos SI, la funcion continua y el usuario se elimina. Seguido de eso, se recarga la pagina. 
// 58: Metodo era GET, que recibia. Metodo DELETE envia la request. se dirije a la url api/usuarios/id y elimina el registro.



