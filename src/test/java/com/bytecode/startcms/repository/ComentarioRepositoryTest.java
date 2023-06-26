package com.bytecode.startcms.repository;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.Comentario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class ComentarioRepositoryTest {

    @Autowired
    private ComentarioRepository comentarioRepository;

    /*
    @Test
    public void testInsert(){
        Comentario comentario = new Comentario();
        comentario.setComentario("ComentarioA");
        comentario.setIdPost(3);
        comentario.setIdUsuario(1);
        comentario.setRespuesta(null);

        Assert.assertTrue(comentarioRepository.save(comentario));
    }

     */

    @Test
    public void testUpdate(){
        Comentario comentario = new Comentario();
        comentario.setComentario("ComentarioB");
        comentario.setIdComentario(1);
        comentario.setIdPost(3);
        comentario.setIdUsuario(1);
        comentario.setRespuesta(null);

        Assert.assertTrue(comentarioRepository.update(comentario));
    }

    /*
    @Test
    public void testFindById(){
        Comentario comentario = comentarioRepository.findById(1);
        Assert.assertTrue(comentario!=null);
        Assert.assertTrue("ComentarioB".equals(comentario.getComentario()));
    }

     */
/*
    @Test
    public void testFindAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        Assert.assertFalse(comentarioRepository.findAll(pageable).isEmpty());
    }

 */
}
