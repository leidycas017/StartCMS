package com.bytecode.startcms.repository;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.Contenido;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class ContenidoRepositoryTest {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Test
    public void testInsert(){
        Contenido contenido = new Contenido();
        contenido.setContenido("Hola");
        contenido.setIdPost(3);
        contenido.setTipo(String.class.getName());
        //contenido.setIdContenido(1);

        Assert.assertTrue(contenidoRepository.save(contenido));
    }

    @Test
    public void testUpdate(){
        Contenido contenido = new Contenido();
        contenido.setContenido("HolaAA");
        contenido.setIdPost(3);
        contenido.setTipo(String.class.getName());
        contenido.setIdContenido(1);

        Assert.assertTrue(contenidoRepository.update(contenido));
    }

    @Test
    public void testFindById(){
        Assert.assertTrue(contenidoRepository.findById(1).getContenido().equalsIgnoreCase("HolaAA"));
    }

    @Test
    public void testFindAll(){
        Assert.assertFalse(contenidoRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }
}
