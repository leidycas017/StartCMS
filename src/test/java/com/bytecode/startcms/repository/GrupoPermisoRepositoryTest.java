package com.bytecode.startcms.repository;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.GrupoPermiso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class GrupoPermisoRepositoryTest {
    /*
    @Autowired
    private GrupoPermisoRepository grupoPermisoRepository;

    @Test
    public void testInsert(){
        GrupoPermiso grupoPermiso = new GrupoPermiso();
        grupoPermiso.setIdGrupo(1);
        grupoPermiso.setIdPermiso(1);
        Assert.assertTrue(grupoPermisoRepository.save(grupoPermiso));
    }

    @Test
    public void testUpdate(){
        GrupoPermiso grupoPermiso = new GrupoPermiso();
        grupoPermiso.setIdGrupo(1);
        grupoPermiso.setIdPermiso(2);
        Assert.assertTrue(grupoPermisoRepository.update(grupoPermiso));
    }

    @Test
    public void testFindById(){
        Assert.assertTrue(grupoPermisoRepository.findById(1).getIdGrupo()==1);
    }

    @Test
    public void testFindAll(){
        Assert.assertFalse(grupoPermisoRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

*/

}
