package com.bytecode.startcms.repository;

import com.bytecode.startcms.model.PostMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class PostMetadataRepository implements PostMetadataRep{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(PostMetadata postMetadata) {
        try {
            String sql = String.format("insert into PostMetadata (Clave, Valor, Tipo, IdPost)" +
                            " values('%s','%s', '%s','%d')" ,
                    postMetadata.getClave(), postMetadata.getValor(), postMetadata.getTipo(), postMetadata.getIdPost());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(PostMetadata postMetadata) {
        if(  postMetadata.getIdPostMetadata() > 0){
            String sql = String.format("update PostMetadata set Clave='%s', Valor='%s', Tipo='%s', IdPost='%d'" +
                            " where IdPostMetadata='%d'",
                    postMetadata.getClave(), postMetadata.getValor(), postMetadata.getTipo(), postMetadata.getIdPostMetadata());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<PostMetadata> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public PostMetadata findById(int Id) {
        return null;
    }
}
