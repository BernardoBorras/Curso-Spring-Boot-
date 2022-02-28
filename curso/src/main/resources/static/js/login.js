
$(document).ready(function() {

});

      
    async function iniciarSesion() {
    
        let datos = {};                                          // Objeto de js. almacena en sus atributos, los datos del formulario. 
        datos.email = document.getElementById('txtEmail').value;
        datos.password = document.getElementById('txtPassword').value;
        

        const request = await fetch('api/login', {    // Con este codigo hace el llamado al servidor
          method: 'POST',                             // Usamos POST para registrar usuario y para iniciar sesion.
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(datos)               //  Enviamos el objeto js convertido a json
                                                
        });                            
      
        const respuesta = await request.text();   // Almacena el json con los datos de inicio de sesion.

        if (respuesta == 'OK'){
        window.location.href = 'usuarios.html'
        }else {
        alert("Las credenciales son incorrectas, intente nuevamente")
        }

    }
      
     
      
      