// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#dataTable').DataTable();
});

async function cargarUsuarios() {
      const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await request.json();

       listadoHtml = '';
       for (let usuario of usuarios) {
          let btnEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm">   <i class="fas fa-trash"></i> </a>' ;

          let usuarioHtml = '<tr>  <td>'+usuario.id+'</td>   <td>'+usuario.nombre +'</td> <td>'+usuario.apellido+'</td>  <td>'
            +usuario.telefono+'</td>  <td> '+btnEliminar+' </td> </tr>';

          listadoHtml += usuarioHtml;
       }

      //agregamos dentro del body de la tabla la variable usuario formateado como html
      document.querySelector('#dataTable tbody').outerHTML = listadoHtml;
    }//cargarUsuarios

async function eliminarUsuario(id) {
        const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'},
       });
       alert("eliminado usuario de id: "+id);
}



