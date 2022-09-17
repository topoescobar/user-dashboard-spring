package com.cursolucasmoy.curso.dao;

//DAO: data acces object, se va a comunicar con la persistenicia.
// La clase es de tipo interface, se declaran las funciones a utilizar y si no se usan no se puede compilar. obliga a usar las funciones

import com.cursolucasmoy.curso.models.Usuario;
import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);
}
