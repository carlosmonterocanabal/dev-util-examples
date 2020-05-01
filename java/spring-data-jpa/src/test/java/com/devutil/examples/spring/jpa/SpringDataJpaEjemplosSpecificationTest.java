package com.devutil.examples.spring.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.devutil.examples.spring.jpa.repository.customobjects.Entidad;
import com.devutil.examples.spring.jpa.repository.specifications.EntidadFindParams;
import com.devutil.examples.spring.jpa.repository.specifications.EntidadService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "/entidad-datos-test.sql")
@Transactional
public class SpringDataJpaEjemplosSpecificationTest {

    @Autowired
    private EntidadService entidadService;

    @Test
    public void ejemplo1Specification() {

        List<Entidad> items = entidadService
                .findByCriteria(EntidadFindParams.builder().edad(33).build());

        Assert.assertEquals(items.size(), 4);
        items.stream().forEach(i -> Assert.assertEquals(i.getEdad().intValue(), 33));

    }

    @Test
    public void ejemplo2Specification() {

        List<Entidad> items = entidadService
                .findByCriteria(EntidadFindParams.builder().edadMin(20).edadMax(30)
                        .textoNombre("Carlos").build());

        Assert.assertEquals(items.size(), 2);
        items.stream().forEach(i -> {
            Assert.assertTrue(i.getEdad() >= 20 && i.getEdad() <= 30);
            Assert.assertEquals(i.getNombre(), "Carlos");
        });

    }

}
