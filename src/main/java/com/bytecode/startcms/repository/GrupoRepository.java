package com.bytecode.startcms.repository;

import com.bytecode.startcms.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class GrupoRepository implements GrupoRep{
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        return null;
    }

    @Override
    public Grupo findById(int Id) {
        return null;
    }
}
