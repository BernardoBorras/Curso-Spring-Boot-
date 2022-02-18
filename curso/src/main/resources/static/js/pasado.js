



async function cargarUsuarios() {


// 'api/usuarios' es la url de la funcion getUsuario() que se encuentra en UsusarioController.java. Enencargada
// de devolvernos un json con los datos de todos los usuario. Lo que estamos haciendo con este request es invocar
// una funcion de la clase UsuarioController.java que nos va a devolver los datos desde el back end.

      const request = await fetch('api/usuarios', {

        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await request.json();
      console.log(content);
    }

