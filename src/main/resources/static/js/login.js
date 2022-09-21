$(document).ready(function() {
});

async function iniciarSesion() {
    let datos = {};

    datos.nombre = document.getElementById('inputName').value;
    datos.password = document.getElementById('inputPass').value;

      const request = await fetch('api/login', { //se comunica con la api AuthController
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos) //le pasamos los datos que ingresamos por formulario y lo transforma a JSON
      });
      const respuesta = await request.text(); //
      if (respuesta == 'ok') { //ok y fail son las respuestas de loginUser en AuthController
        window.location.href = 'usuarios.html'
      } else {
        alert('datos incorrectos');
      }

    }