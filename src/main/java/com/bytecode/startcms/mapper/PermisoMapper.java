package com.bytecode.startcms.mapper;

import com.bytecode.startcms.model.Permiso;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermisoMapper implements RowMapper<Permiso> {
    @Override
    public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
        Permiso permiso = new Permiso();
        permiso.setIdPermiso(rs.getInt("IdPermiso"));
        permiso.setNombre(rs.getString("Nombre"));
        return permiso;
    }
}
