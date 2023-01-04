package com.bytecode.startcms.repository;

import com.bytecode.startcms.model.UsuarioMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(UsuarioMetadata object) {
        return false;
    }

    @Override
    public boolean update(UsuarioMetadata object) {
        return false;
    }

    @Override
    public List<UsuarioMetadata> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UsuarioMetadata findById(int Id) {
        return null;
    }
}
