// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function registrarUsuario() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.telefono = document.getElementById('txtTelefono').value;
    datos.password = document.getElementById('txtPass').value;

    let passControl =  document.getElementById('txtPassRep').value;
    if (passControl != datos.password) {
      alert("las contraselas ingresadas no coinciden")
      return; //si son distintas corta y no ejecuta el request
    } 
    
      const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos) //le pasamos los datos que ingresamos por formulario y lo transforma a JSON
      });
      location.reload();
    }