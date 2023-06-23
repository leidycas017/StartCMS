package com.bytecode.startcms.repository;

import com.bytecode.startcms.mapper.PermisoMapper;
import com.bytecode.startcms.model.Permiso;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PermisoRepository implements PermisoRep {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Permiso permiso) {
        try {
            String sql = String.format("insert into Permiso (Nombre)" +
                            " values('%s')" ,
                    permiso.getNombre());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Permiso permiso) {
        if( permiso.getIdPermiso() > 0){
            String sql = String.format("update Permiso set Nombre='%s'" +
                            " where IdPermiso='%d'",
                    permiso.getNombre(), permiso.getIdPermiso());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public Permiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from permiso where IdPermiso = ?",
                params, new PermisoMapper());
    }

    @Override
    public List<Permiso> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from permiso", new PermisoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
