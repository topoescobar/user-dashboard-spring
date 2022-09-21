package com.cursolucasmoy.curso.controllers;

import com.cursolucasmoy.curso.dao.UsuarioDao;
import com.cursolucasmoy.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //gestiona las peticiones http en formato json
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody Usuario usuario) { //transforma el json recibido a un objeto
        if (usuarioDao.verificarLogin(usuario)) {
            return "ok";
        } return  "fail";
    }
}
