package com.bytecode.startcms.repository;


import com.bytecode.startcms.mapper.ContenidoMapper;
import com.bytecode.startcms.model.Contenido;
import jakarta.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ContenidoRepository implements ContenidoRep {
    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Contenido contenido) {
        try {
            String sql = String.format("insert into Contenido (Contenido, IdPost, Tipo)" +
                            " values('%s', '%d', '%s')" ,
                    contenido.getContenido(), contenido.getIdPost(), contenido.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            logger.error(e);
            return false;
        }
    }

    @Override
    public boolean update(Contenido contenido) {
        if(contenido.getIdContenido() > 0){
            String sql = String.format("update Contenido set Contenido='%s', Tipo='%s'" +
                            " where IdContenido='%d'",
                    contenido.getContenido(), contenido.getTipo(), contenido.getIdContenido());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public Contenido findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from contenido where IdContenido = ?",
                params, new ContenidoMapper());
    }

    @Override
    public List<Contenido> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from contenido", new ContenidoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
