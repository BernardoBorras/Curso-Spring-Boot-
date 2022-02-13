
$(document).ready(function() {

});

      
    async function iniciarSesion() {
    
        let datos = {};                                // Creamos el objeto de js. Luego le asignamos los atributos.
        datos.email = document.getElementById('txtEmail').value;
        datos.password = document.getElementById('txtPassword').value;
        

        const request = await fetch('api/login', {    // Con este codigo hace el llamado al servidor
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(datos)  //  Le esta pasando todos los datos necesarios para hacer el inicio de sesion.
                                                
        });                            
      
        const respuesta = await request.json();   // Almacena el json con los datos de inicio de sesion.

        alert("Funcion Activada")
    }
      
     
      
      