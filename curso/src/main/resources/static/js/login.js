
$(document).ready(function() {
});

    async function iniciarSesion() {
    
        let datos = {};                                  // Objeto de js. almacena en sus atributos, los datos del formulario.
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
      
        const respuesta = await request.text();        // Almacena la respuesta de la request (token)

        if (respuesta != 'FAIL'){                // Si la resp fue un string token, almacenalo en el local storage.
                                                 // Y redirigime a la pagina usuarios.html, caso contrario, alert!
            localStorage.token = respuesta;          // Guardar token del lado del browser.
            localStorage.email = datos.email;        // Podemos guardar mas de informacion en local storage. email
            window.location.href = 'usuarios.html'

        }else {
            alert("Las credenciales son incorrectas, intente nuevamente")
        }
    }
      
     
      
      