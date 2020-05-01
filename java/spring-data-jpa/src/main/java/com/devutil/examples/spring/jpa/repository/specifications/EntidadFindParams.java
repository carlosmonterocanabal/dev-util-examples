package com.devutil.examples.spring.jpa.repository.specifications;

import java.util.Calendar;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EntidadFindParams {

    private List<Integer> ids;

    private String textoNombre;

    private String email;

    private Integer edad, edadMin, edadMax;

    private Calendar fecha, fechaMin, fechaMax;

}
