package com.bytecode.startcms.repository;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.PostMetadata;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PostMetadataRepositoryTest {

    @Autowired
    private PostMetadataRepository repository;

    @Test
    public void testInsert(){
        PostMetadata postMetadata = new PostMetadata();
        postMetadata.setClave("Visitas");
        postMetadata.setIdPost(3);
        postMetadata.setTipo("1");
        postMetadata.setValor("13");
        //postMetadata.setIdPostMetadata(1);

        Assert.assertTrue(repository.save(postMetadata));
    }

    @Test
    public void testUpdate(){
        PostMetadata postMetadata = new PostMetadata();
        postMetadata.setClave("Visitas");
        postMetadata.setIdPost(3);
        postMetadata.setTipo("2");
        postMetadata.setValor("18");
        postMetadata.setIdPostMetadata(1);

        Assert.assertTrue(repository.update(postMetadata));
    }

    @Test
    public void testFindAll(){
        Assert.assertFalse(repository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

    @Test
    public void testFindById(){
        Assert.assertTrue(repository.findById(1).getValor().equalsIgnoreCase("18"));
    }
}
