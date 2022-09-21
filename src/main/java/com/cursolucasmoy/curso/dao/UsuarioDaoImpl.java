package com.cursolucasmoy.curso.dao;

import com.cursolucasmoy.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        String query = "FROM Usuario WHERE nombre = :nombre "; //Usuario es la clase no la tabla BD
        List<Usuario> lista = entityManager.createQuery(query) //creamos la lista que solo deberia tener un usuario recuperado
                .setParameter("nombre",usuario.getNombre())
                .getResultList();

        String passHash = lista.get(0).getPassword(); //obtenemos la pass hasheada desde la BD

        //si el usuario no existe da una lista vacia que dara error al obtener passw
        if (lista.isEmpty()) {
            return false;
        }

        char[] passRaw = usuario.getPassword().toCharArray(); //obtener contraseña ingresada por usuario y pasar a char[] para usar verify

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passHash, passRaw); //devuelve bool


    }


}
