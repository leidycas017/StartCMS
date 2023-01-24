package com.bytecode.startcms.component;

import com.bytecode.startcms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class TestDatabaseConfiguration {

    @Bean
    public DataSource getDtaSource(){
        DriverManagerDataSource dataSoruce = new DriverManagerDataSource();
        dataSoruce.setDriverClassName("com.mysql.jdbc.Driver");
        dataSoruce.setUrl("jdbc:mysql://localhost:3306/test_blog");
        dataSoruce.setUsername("bytecode");
        dataSoruce.setPassword("root1234");
        return dataSoruce;
    }

    @Bean
    public CategoriaRepository categoriaRepository(){
        return new CategoriaRepository();
    }

    @Bean
    public ComentarioRepository comentarioRepository(){
        return new ComentarioRepository();
    }

    @Bean
    public ContenidoRepository contenidoRepository(){
        return new ContenidoRepository();
    }

    @Bean
    public GrupoRepository grupoRepository(){
        return new GrupoRepository();
    }

    @Bean
    public PermisoRepository permisoRepository(){
        return new PermisoRepository();
    }

    @Bean
    public GrupoPermisoRepository grupoPermisoRepository(){
        return new GrupoPermisoRepository();
    }

    @Bean
    public PostRepository postRepository(){return new PostRepository();}

    @Bean
    public PostMetadataRepository postMetadataRepository(){
        return new PostMetadataRepository();
    }

    @Bean
    public UsuarioRepository usuarioRepository(){
        return new UsuarioRepository();
    }

    @Bean
    public UsuarioMetadataRepository usuarioMetadataRepository(){
        return new UsuarioMetadataRepository();
    }

}
