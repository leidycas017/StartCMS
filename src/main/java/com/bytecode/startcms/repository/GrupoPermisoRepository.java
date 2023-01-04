package com.bytecode.startcms.repository;



import com.bytecode.startcms.model.GrupoPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class GrupoPermisoRepository  implements GrupoPermisoRep{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(GrupoPermiso grupoPermiso) {
        try {
            String sql = String.format("insert into grupo_permiso (IdGrupo,IdPermiso)" +
                            " values('%d', '%d')" ,
                    grupoPermiso.getIdGrupo(), grupoPermiso.getIdPermiso());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(GrupoPermiso grupoPermiso) {
        if(grupoPermiso.getIdGrupo() > 0){
            String sql = String.format("update grupo_permiso set IdPermiso='%d'" +
                            " where IdGrupo='%d'",
                    grupoPermiso.getIdPermiso(), grupoPermiso.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<GrupoPermiso> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public GrupoPermiso findById(int Id) {
        return null;
    }
}
