package com.bytecode.startcms.repository;



import com.bytecode.startcms.mapper.ContenidoMapper;
import com.bytecode.startcms.mapper.GrupoPermisoMapper;
import com.bytecode.startcms.model.Contenido;
import com.bytecode.startcms.model.GrupoPermiso;
import jakarta.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import javax.sql.DataSource;
import java.util.List;

//@Repository
public class GrupoPermisoRepository  implements GrupoPermisoRep{
    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

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
    public GrupoPermiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from grupo_permiso where IdGrupoPermiso = ?",
                params, new GrupoPermisoMapper());
    }

    @Override
    public List<GrupoPermiso> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from grupo_permiso", new GrupoPermisoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
