package com.cursolucasmoy.curso.controllers;
//los controllers sirven para manejar las URL

import com.cursolucasmoy.curso.dao.UsuarioDao;
import com.cursolucasmoy.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired //hace que usuariodao cree un objeto, si se reutiliza autowired va a compartir memoria(no zarparse con el uso)
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}") //get es el metodo por defecto no haria falta escribirlo
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setId(id);
        usuarioNuevo.setNombre("ivan");
        usuarioNuevo.setApellido("garcia");
        usuarioNuevo.setTelefono("272727");
        usuarioNuevo.setPassword("lik");
        return usuarioNuevo;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }


    @RequestMapping(value = "usuario1")
    public Usuario editar() {
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombre("ivan");
        usuarioNuevo.setApellido("garcia");
        usuarioNuevo.setTelefono("272727");
        usuarioNuevo.setPassword("lik");
        return usuarioNuevo;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) { //recibe el id pasado por url
        usuarioDao.eliminar(id);
     }

    @RequestMapping(value = "usuario3")
    public Usuario buscar() {
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombre("ivan");
        usuarioNuevo.setApellido("garcia");
        usuarioNuevo.setTelefono("272727");
        usuarioNuevo.setPassword("lik");
        return usuarioNuevo;
    }

}

