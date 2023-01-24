package com.bytecode.startcms.repository;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.Permiso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PermisoRepositoryTest {
    @Autowired
    private PermisoRepository repository;

    @Test
    public void testInsert(){
        Permiso permiso = new Permiso();
        //permiso.setIdPermiso(1);
        permiso.setNombre("Nuevo Permismo");

        Assert.assertTrue(repository.save(permiso));
    }

    @Test
    public void testUpdate(){
        Permiso permiso = new Permiso();
        permiso.setIdPermiso(1);
        permiso.setNombre("Nuevo Permiso2");

        Assert.assertTrue(repository.update(permiso));
    }

    @Test
    public void findById(){
        Assert.assertTrue(repository.findById(1).getNombre().equalsIgnoreCase("Nuevo Permiso2"));
    }

    @Test
    public void findAll(){
        Assert.assertFalse(repository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }
}
