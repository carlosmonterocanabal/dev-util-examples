package com.devutil.examples.spring.jpa.repository.customobjects;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EntidadRepository extends CrudRepository<Entidad, Integer> {

    @Query("SELECT e.nombre, COUNT(*) "
            + "FROM Entidad e "
            + "GROUP BY e.nombre "
            + "HAVING COUNT(*) > 1 "
            + "ORDER BY 2 DESC, 1 ASC")
    List<Object[]> calcularGroupByNombre();

    @Query("SELECT new com.devutil.examples.spring.jpa.repository.customobjects.EntidadNombre(e.nombre, COUNT(*)) "
            + "FROM Entidad e "
            + "GROUP BY e.nombre "
            + "HAVING COUNT(*) > 1 "
            + "ORDER BY 2 DESC, 1 ASC")
    List<EntidadNombre> calcularGroupByEntidadNombre();

    @Query("SELECT e.nombre AS nombre, COUNT(*) AS contador "
            + "FROM Entidad e "
            + "GROUP BY e.nombre "
            + "HAVING COUNT(*) > 1 "
            + "ORDER BY 2 DESC, 1 ASC")
    List<IEntidadNombre> calcularGroupByIEntidadNombre();

    @Query(value = "SELECT e.nombre AS nombre, COUNT(*) AS contador "
            + "FROM entidad e "
            + "GROUP BY e.nombre "
            + "HAVING COUNT(*) > 1 "
            + "ORDER BY 2 DESC, 1 ASC", nativeQuery = true)
    List<IEntidadNombre> calcularGroupByIEntidadNombreNative();

}
