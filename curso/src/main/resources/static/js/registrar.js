$(document).ready(function() {
// on ready   
  });
  
  
  async function registrarUsuarios() {
    const request = await fetch('usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
  
  // constante que almacena el json con los datos de todos los usuarios. Transforma a json.
  const usuarios = await request.json();
  
  
  
  
  
  
  }
  
 
  
  
  
  
  