// Call the dataTables jQuery plugin.   +++   Esto se encarga de generar la paginacion. 

$(document).ready(function() {
  cargarUsuarios();     // activar la funcion al cargar la pagina
  $('#usuarios').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario(){
document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}



// La clase cargarUsuarios() contiene las funciones... 
//      cargarUsuarios()
//      eliminarUsuario(id)
// (Ambas se activan desde usuarios.html)


// .................... Implementacion de JWT (parte 2.1 - envio de token en las request)

// Toda request (solicitud) tiene un header(encabezado) en el que proporciona informacion.
// En este caso Vamos a agregar un header mas, con la informacion del token,
//      Como el token va a ser utilizado en ambas funciones js : cargarUsuarios() y eliminarUsuario(id)
//      Creamos una funcion para reutilizar esto.

function getHeaders(){
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token   // Tomamos el token del local storage y lo enviamos.
  }
}


// ..................................................................................   cargarUsuarios() 


async function cargarUsuarios() {
    //                                                            La funcion que invocamos escupe un list de objetos usuario
  const request = await fetch('api/usuarios', {                // La variable request almacena el resultado del llamado
    method: 'GET',
    headers: getHeaders()
    });                                                           // En javaScript las variables pueden almacenar json.
    const usuarios = await request.json(); // constante que almacena el json con los datos de todos los usuarios. Transforma a json.
    let listadoHtml='';
    for (let usuario of usuarios){
        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
        let telefono = usuario.telefono == null ? '-' : usuario.telefono;  // En js el ? es otra forma de utilizar un if() (mas comprimido).
        let usuarioHtml = '<tr><td>213</td><td>'+usuario.nombre+' '+usuario.apellido
                      +'</td><td>'+usuario.email+'</td><td>'+telefono+'</td><td>'
                      + usuario.password+'</td><td>' + botonEliminar + '</td></tr>'
        listadoHtml += usuarioHtml;
        console.log(usuario)
    }
document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

// let listadoHtml=''  :   Listado vacio que va ir recibiendo usuarios del bucle for
// 25: recorre la variable ususarios que contiene el json con los datos de todos los usuarios.
// 39: en la primer vuelta lee el primer registro del json y crea html de manera dinamica. Html con la estructura que lleva ususarios.html
// 31: ese html dinamico se almaceno en usuarioHtml. Lo sumamos a la bariable alojada fuera del bucle listadoHtml
// 33: en cada vuelta del bucle se va a imprimir en consola, que usuario del json que contiene usuarios. Estamos recorriendo.
// 36: Luego de haber cargado la variable listadoHtml con todo el html diamico necesario (todos los usuarios). Lo insertamos en usuarios.html





// .................................................................................. Eliminar Usuario

async function eliminarUsuario(id) {

  if (!confirm('¿Desea eliminar este usuario?')){ return; }

  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });
  location.reload()
}

// Funcion eliminarUsuario() se activa cuando se apreta cualquiera de los botones creados en cargarUsuarios()
//                           al ser activada se envia el (argumento = identificador de cada usuario)

// IF() : Poner un if al principio de la funcion eliminarUsuario() nos permite cortar el flujo de la funcion
//          En caso de haber presionado por error, nos aparece un cartelito de confirmacion.
//          en este caso lo invertimos poniendo ! al principio. Si ponemos NO, corta el flujo de la funcion.
//          si ponemos SI, la funcion continua y el usuario se elimina. Seguido de eso, se recarga la pagina.

// Metodo DELETE  :  envia la request. se dirije a la url api/usuarios/id y elimina el registro.





