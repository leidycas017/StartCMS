package com.bytecode.startcms.repository;


import com.bytecode.startcms.mapper.GrupoMapper;
import com.bytecode.startcms.model.Grupo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class GrupoRepository implements GrupoRep{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Grupo grupo) {
        try {
            String sql = String.format("insert into grupo (Nombre)" +
                            " values('%s')" ,
                    grupo.getNombre());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Grupo grupo) {
        if(grupo.getIdGrupo() > 0){
            String sql = String.format("update Grupo set Nombre='%s'" +
                            " where IdGrupo='%d'",
                    grupo.getNombre(), grupo.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Grupo> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from grupo", new GrupoMapper());
    }

    @Override
    public Grupo findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from grupo where IdGrupo = ?",
                params, new GrupoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
