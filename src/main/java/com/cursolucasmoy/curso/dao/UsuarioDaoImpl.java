package com.cursolucasmoy.curso.dao;

import com.cursolucasmoy.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository     //conexion BD
@Transactional //permite armar las consultas a la BD

public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager; //hace la conexion con la BD

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario"; //Usuario es la clase no la tabla BD
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id); //buscar el ID del usuario en la BD
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarLogin(Usuario usuario) {
        String query = "FROM Usuario WHERE nombre = :nombre AND password = :password "; //Usuario es la clase no la tabla BD
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("nombre",usuario.getNombre())
                .setParameter("password", usuario.getPassword())
                .getResultList();

        return !lista.isEmpty();
    }


}
