package com.bytecode.startcms.repository;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.UsuarioMetadata;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class UsuarioMetadataRepositoryTest {
    /*
    @Autowired
    private UsuarioMetadataRepository repository;

    @Test
    public void testInsert(){
        UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
        usuarioMetadata.setClave("Edad");
        usuarioMetadata.setIdUsuario(1);
        usuarioMetadata.setTipo("1");
        usuarioMetadata.setValor("18");
        usuarioMetadata.setIdUsuarioMetadata(1);

        Assert.assertTrue(repository.save(usuarioMetadata));
    }

    @Test
    public void testUpdate(){
        UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
        usuarioMetadata.setClave("Edad");
        usuarioMetadata.setIdUsuario(1);
        usuarioMetadata.setTipo("1");
        usuarioMetadata.setValor("19");
        usuarioMetadata.setIdUsuarioMetadata(1);

        Assert.assertTrue(repository.update(usuarioMetadata));
    }

    @Test
    public void testFindAll(){
        Assert.assertFalse(repository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

    @Test
    public void testById(){
        Assert.assertTrue(repository.findById(1).getValor().equalsIgnoreCase("19"));
    }

     */
}
