$(document).ready(function() {
// on ready   
  });

  // En esta funcion se van a extraer los datos que se ingresen en el formulario registrar.html. 
  // Los datos que vamos a enviar al registrar tienen que tener el mismo formato que los datos que recibimos cuando los solicitamos. 
  //      debido a esto, nos aseguramos que el objeto de js "datos" tenga los atributos correspondientes. Una vez cargado el objeto js 
  //      con los datos. Mediante el metodo POST vamos a vamos a enviarle a UsuarioController el objeto js transformado a JSON. 

  
  async function registrarUsuario() {

    let datos = {};                                               // En esta linea creamos el objeto de js. Luego le asignamos los atributos. 
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    
    let repetirPassword = document.getElementById('txtRepeatPassword').value;

    if (repetirPassword != datos.password){
        alert('Las contraseñas no coinciden');
        return;                                      // El return se usa para que corte toda la funcion, en este caso corta registrarUsuarios()
    }

    const request = await fetch('api/usuarios', {    // misma url
      method: 'POST',                                // diferente metodo
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)  // Lo que hace esto es llamar a la funcion JSON.stringify
      
// JSON.stringify agarra cualquier objeto de js y lo convierte a un string de json, En este caso va a agarrar el objeto datos.....   IMPORTANTE


    });
  
  const usuarios = await request.json();
  
  
  
  
  
  
  }
  
 
  
  
  
  
  