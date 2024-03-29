package com.bytecode.startcms;

import com.bytecode.startcms.component.TestDatabaseConfiguration;
import com.bytecode.startcms.model.Usuario;
import com.bytecode.startcms.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;
/*
    @Test
    public void testInsert(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Briones");
        usuario.setContraseña("1234");
        usuario.setCorreo("david_briones@bytepl.com");
        usuario.setIdGrupo(1);
        usuario.setNombre("David");

        Assert.assertTrue(usuarioRepository.save(usuario));
    }

 */

    @Test
    public void testUpdate(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setApellido("Briones");
        usuario.setContraseña("1234");
        usuario.setCorreo("aprendefacil1020@gmail.com");
        usuario.setIdGrupo(1);
        usuario.setNombre("DavidBB");

        Assert.assertTrue(usuarioRepository.update(usuario));
    }

    @Test
    public void testFindAll(){
        Assert.assertFalse(usuarioRepository.findAll(new SpringDataWebProperties.Pageable()).isEmpty());
    }

    @Test
    public void testFindById(){
        Assert.assertTrue(usuarioRepository.findById(1).getNombre().equalsIgnoreCase("DavidBB"));
    }

}
