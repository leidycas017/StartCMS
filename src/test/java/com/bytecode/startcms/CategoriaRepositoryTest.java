package com.bytecode.startcms;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.Categoria;
import com.bytecode.startcms.repository.CategoriaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class} )
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Test
    public void testInsert(){
        Categoria categoria = new Categoria();
        categoria.setNombre("Test2");
        categoria.setDescripcion("Este es un ejemplo de categoria superior");
        categoria.setCategoriaSuperior(1);

        boolean result = categoriaRepository.save(categoria);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdate(){
        Categoria categoria = new Categoria();

        categoria.setIdCategoria(1);
        categoria.setNombre("Test3");
        categoria.setDescripcion("Este es un ejemplo de categoria superior");
        categoria.setCategoriaSuperior(1);

        boolean result = categoriaRepository.update(categoria);
        Assert.assertTrue(result);
    }
/*
    @Test
    public void testFindById(){
        Categoria categoria = categoriaRepository.findById(1);
        Assert.assertTrue(categoria!=null);
        Assert.assertTrue("Test3".equals(categoria.getNombre()));
    }

    @Test
    public void testFindAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        Assert.assertFalse(categoriaRepository.findAll(pageable).isEmpty());
    }

 */

}

