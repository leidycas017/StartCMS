package com.bytecode.startcms.mapper;

import com.bytecode.startcms.model.PostMetadata;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMetadataMapper implements RowMapper<PostMetadata> {
    @Override
    public PostMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostMetadata postMetadata = new PostMetadata();
        postMetadata.setClave(rs.getString("Clave"));
        postMetadata.setIdPost(rs.getInt("IdPost"));
        postMetadata.setIdPostMetadata(rs.getInt("IdPostMetadata"));
        postMetadata.setTipo(rs.getString("Tipo"));
        postMetadata.setValor(rs.getString("Valor"));
        return postMetadata;
    }
}
