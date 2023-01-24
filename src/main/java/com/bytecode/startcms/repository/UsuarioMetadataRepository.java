package com.bytecode.startcms.repository;

import com.bytecode.startcms.mapper.UsuarioMetadataMapper;
import com.bytecode.startcms.model.UsuarioMetadata;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(UsuarioMetadata usuarioMetadata) {
        try {
            String sql = String.format("insert into usuario_metadata (IdUsuario, Clave, Valor, Tipo) values ('%d', '%s', '%s', '%s')",
                    usuarioMetadata.getIdUsuario(), usuarioMetadata.getClave(), usuarioMetadata.getValor(), usuarioMetadata.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(UsuarioMetadata usuarioMetadata) {
        if(usuarioMetadata.getIdUsuarioMetadata()>0) {
            String sql = String.format("update usuario_metadata set IdUsuario='%d', Clave='%s', Valor='%s', Tipo='%s' where IdUsuarioMetadata='%d'",
                    usuarioMetadata.getIdUsuario(), usuarioMetadata.getClave(), usuarioMetadata.getValor(), usuarioMetadata.getTipo(), usuarioMetadata.getIdUsuarioMetadata());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<UsuarioMetadata> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from usuario_metadata", new UsuarioMetadataMapper());
    }

    @Override
    public UsuarioMetadata findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from usuario_metadata where IdUsuarioMetadata = ?",
                params, new UsuarioMetadataMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
