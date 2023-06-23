package com.bytecode.startcms.repository;

import com.bytecode.startcms.mapper.UsuarioMapper;
import com.bytecode.startcms.model.Usuario;
import jakarta.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import java.util.List;

@Repository
public class UsuarioRepository implements UsuarioRep{
    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Usuario usuario) {
        try {
            String sql = String.format("insert into Usuario (Nombre, Apellido, Contraseña, Correo, IdGrupo) values ('%s', '%s', '%s', '%s', '%d')",
                    usuario.getNombre(), usuario.getApellido(), usuario.getContraseña(), usuario.getCorreo(), usuario.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Usuario usuario) {
        if(  usuario.getIdUsuario() > 0){
            String sql = String.format("update Usuario set Nombre='%s', Apellido='%s', Contraseña='%s', Correo='%s',IdGrupo='%d'" +
                            " where IdUsuario='%d'",
                    usuario.getNombre(), usuario.getApellido(), usuario.getContraseña(), usuario.getCorreo(), usuario.getIdGrupo(), usuario.getIdUsuario());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from Usuario", new UsuarioMapper());
    }
    @Override
    public Usuario findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from Usuario where IdUsuario = ?",
                params, new UsuarioMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
