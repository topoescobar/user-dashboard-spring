$(document).ready(function() {
});

async function iniciarSesion() {
    let datos = {};

    datos.nombre = document.getElementById('inputName').value;
    datos.password = document.getElementById('inputPass').value;

      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos) //le pasamos los datos que ingresamos por formulario y lo transforma a JSON
      });
      const respuesta = await request.json();
    }