package com.devutil.examples.spring.jpa.repository.customobjects;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Entidad {

    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;

    private String email;

    private Integer edad;

    private Calendar fecha;
}
