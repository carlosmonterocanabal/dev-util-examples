package com.devutil.examples.spring.jpa;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.devutil.examples.spring.jpa.repository.customobjects.EntidadNombre;
import com.devutil.examples.spring.jpa.repository.customobjects.EntidadRepository;
import com.devutil.examples.spring.jpa.repository.customobjects.IEntidadNombre;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "/entidad-datos-test.sql")
public class SpringDataJpaEjemplosObjetosCustomTest {

    @Autowired
    private EntidadRepository entidadRepository;

    @Test
    public void ejemploResultadoObjectArray() {

        List<Object[]> resultado = entidadRepository.calcularGroupByNombre();

        Assert.assertEquals(resultado.get(0)[0], "Carlos");
        Assert.assertEquals(resultado.get(0)[1], Long.valueOf(5));

        Assert.assertEquals(resultado.get(1)[0], "Ruben");
        Assert.assertEquals(resultado.get(1)[1], Long.valueOf(5));

        Assert.assertEquals(resultado.get(2)[0], "Alberto");
        Assert.assertEquals(resultado.get(2)[1], Long.valueOf(3));

        Assert.assertEquals(resultado.get(3)[0], "Elena");
        Assert.assertEquals(resultado.get(3)[1], Long.valueOf(3));

        Assert.assertEquals(resultado.get(4)[0], "Luis");
        Assert.assertEquals(resultado.get(4)[1], Long.valueOf(3));

    }

    @Test
    public void ejemploResultadoListObjetoCustom() {

        List<EntidadNombre> resultado = entidadRepository.calcularGroupByEntidadNombre();

        Assert.assertEquals(resultado.get(0).getNombre(), "Carlos");
        Assert.assertEquals(resultado.get(0).getContador(), Long.valueOf(5));

        Assert.assertEquals(resultado.get(1).getNombre(), "Ruben");
        Assert.assertEquals(resultado.get(1).getContador(), Long.valueOf(5));

        Assert.assertEquals(resultado.get(2).getNombre(), "Alberto");
        Assert.assertEquals(resultado.get(2).getContador(), Long.valueOf(3));

        Assert.assertEquals(resultado.get(3).getNombre(), "Elena");
        Assert.assertEquals(resultado.get(3).getContador(), Long.valueOf(3));

        Assert.assertEquals(resultado.get(4).getNombre(), "Luis");
        Assert.assertEquals(resultado.get(4).getContador(), Long.valueOf(3));

    }

    @Test
    public void ejemploResultadoListInterfazCustom() {

        List<IEntidadNombre> resultado = entidadRepository.calcularGroupByIEntidadNombre();

        Assert.assertEquals(resultado.get(0).getNombre(), "Carlos");
        Assert.assertEquals(resultado.get(0).getContador(), Integer.valueOf(5));

        Assert.assertEquals(resultado.get(1).getNombre(), "Ruben");
        Assert.assertEquals(resultado.get(1).getContador(), Integer.valueOf(5));

        Assert.assertEquals(resultado.get(2).getNombre(), "Alberto");
        Assert.assertEquals(resultado.get(2).getContador(), Integer.valueOf(3));

        Assert.assertEquals(resultado.get(3).getNombre(), "Elena");
        Assert.assertEquals(resultado.get(3).getContador(), Integer.valueOf(3));

        Assert.assertEquals(resultado.get(4).getNombre(), "Luis");
        Assert.assertEquals(resultado.get(4).getContador(), Integer.valueOf(3));

    }

    @Test
    public void ejemploResultadoListInterfazCustomQueryNativa() {

        List<IEntidadNombre> resultado = entidadRepository.calcularGroupByIEntidadNombreNative();

        Assert.assertEquals(resultado.get(0).getNombre(), "Carlos");
        Assert.assertEquals(resultado.get(0).getContador(), Integer.valueOf(5));

        Assert.assertEquals(resultado.get(1).getNombre(), "Ruben");
        Assert.assertEquals(resultado.get(1).getContador(), Integer.valueOf(5));

        Assert.assertEquals(resultado.get(2).getNombre(), "Alberto");
        Assert.assertEquals(resultado.get(2).getContador(), Integer.valueOf(3));

        Assert.assertEquals(resultado.get(3).getNombre(), "Elena");
        Assert.assertEquals(resultado.get(3).getContador(), Integer.valueOf(3));

        Assert.assertEquals(resultado.get(4).getNombre(), "Luis");
        Assert.assertEquals(resultado.get(4).getContador(), Integer.valueOf(3));

    }

}
