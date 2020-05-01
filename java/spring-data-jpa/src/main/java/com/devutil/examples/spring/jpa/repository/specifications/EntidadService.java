package com.devutil.examples.spring.jpa.repository.specifications;

import java.util.List;

import com.devutil.examples.spring.jpa.repository.customobjects.Entidad;

public interface EntidadService {

    List<Entidad> findByCriteria(EntidadFindParams params);

}
