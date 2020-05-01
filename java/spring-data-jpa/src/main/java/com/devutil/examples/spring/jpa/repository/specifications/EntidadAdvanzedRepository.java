package com.devutil.examples.spring.jpa.repository.specifications;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.devutil.examples.spring.jpa.repository.customobjects.Entidad;

public interface EntidadAdvanzedRepository
        extends CrudRepository<Entidad, Integer>, JpaSpecificationExecutor<Entidad> {

}
