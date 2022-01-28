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
  const usuarios = await request.json();


  let usuario = '<tr><td>213</td><td>Perrosquin Rock</td><td>lucas@gmail.com</td><td>1312456</td><td>5464</td><td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>'

  document.querySelector('#usuarios tbody').outerHTML = usuario;  // el error estaba en escribir outher/outer

}

