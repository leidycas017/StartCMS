package com.bytecode.startcms.repository;

import com.bytecode.startcms.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class UsuarioRepository implements UsuarioRep{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Usuario usuario) {
        try {
            String sql = String.format("insert into Usuario (Nombre, Apellido, Contraseña, Correo,IdGrupo,)" +
                            " values('%s','%s', '%s','%s', '%d')" ,
                    usuario.getNombre(), usuario.getApellido(), usuario.getContraseña(), usuario.getCorreo(), usuario.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Usuario usuario) {
        if(  usuario.getIdUsuario() > 0){
            String sql = String.format("update Usuario set Nombre='%s', Apellido='%s', Contraseña='%s', Correo='%s',IdGrupo='%s'" +
                            " where IdUsuario='%d'",
                    usuario.getNombre(), usuario.getApellido(), usuario.getContraseña(), usuario.getCorreo(), usuario.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Usuario findById(int Id) {
        return null;
    }
}
