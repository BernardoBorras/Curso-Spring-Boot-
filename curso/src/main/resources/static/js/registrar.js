$(document).ready(function() {
// on ready   
  });


// Esta clase contiene la funcion  registrarUsuario()
// Que se activa desde registrar.html




  // En esta funcion registrarUsuario() se van a extraer los datos que se ingresen en el formulario registrar.html. 
  // Los datos que vamos a enviar al registrar tienen que tener el mismo formato que los datos que recibimos cuando los solicitamos. 
  //      debido a esto, nos aseguramos que el objeto de js "datos" tenga los atributos correspondientes. Una vez cargado el objeto js 
  //      con los datos. Mediante el metodo POST vamos a vamos a enviarle a UsuarioController el objeto js transformado a JSON. 

  
  async function registrarUsuario() {

      let datos = {};                                               // Creamos el objeto de js. Le asignamos atributos (datos del form)
        datos.nombre = document.getElementById('txtNombre').value;
        datos.apellido = document.getElementById('txtApellido').value;
        datos.email = document.getElementById('txtEmail').value;
        datos.password = document.getElementById('txtPassword').value;
    
      let repetirPassword = document.getElementById('txtRepeatPassword').value;  // almacenamos en variable .js el campo repetirpass

      if (repetirPassword != datos.password){
          alert('Las contraseñas no coinciden');
          return;                                      // El return se usa para que corte toda la funcion, en este caso corta registrarUsuarios()
      }

      const request = await fetch('api/usuarios', {    // Misma url que cargarUsuarios() se diferencian por el metodo
        method: 'POST',                                
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)  // Lo que hace esto es llamar a la funcion JSON.stringify. Que agarra cualquier objeto de js
                                     //  y lo convierte a un string de json, En este caso agarra el objeto .js "datos".     IMPORTANTE
      });                            //  Aca en el body ya estamos enviando todos los datos armados. (en json)

      alert("Las cuenta fue creada con exito");
      window.location.href = 'login.html'

    
  }
  
 
  
  
  
  
  