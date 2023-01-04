package com.bytecode.startcms.repository;

import com.bytecode.startcms.model.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class PermisoRepository implements PermisoRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    public List<Permiso> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Permiso findById(int Id) {
        return null;
    }
}
