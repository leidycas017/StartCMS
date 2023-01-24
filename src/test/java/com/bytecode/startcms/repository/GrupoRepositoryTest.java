package com.bytecode.startcms.repository;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.Grupo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class GrupoRepositoryTest {
    @Autowired
    private GrupoRepository grupoRepository;

    @Test
    public void testInsert(){
        Grupo grupo = new Grupo();
        //grupo.setIdGrupo(1);
        grupo.setNombre("Grupo1");

        Assert.assertTrue(grupoRepository.save(grupo));
    }

    @Test
    public void testUpdate(){
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(1);
        grupo.setNombre("Grupo2");

        Assert.assertTrue(grupoRepository.update(grupo));
    }

    @Test
    public void findById(){
        Assert.assertTrue(grupoRepository.findById(1).getNombre().equalsIgnoreCase("Grupo2"));
    }

    @Test
    public void findAll(){
        Assert.assertFalse(grupoRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }
}
