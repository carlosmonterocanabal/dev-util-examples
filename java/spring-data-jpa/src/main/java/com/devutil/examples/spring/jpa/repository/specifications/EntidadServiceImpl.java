package com.devutil.examples.spring.jpa.repository.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.devutil.examples.spring.jpa.repository.customobjects.Entidad;

@Service
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    private EntidadAdvanzedRepository entidadAdvanzedRepository;

    @Override
    public List<Entidad> findByCriteria(EntidadFindParams params) {

        return entidadAdvanzedRepository.findAll(createSpec(params));
    }

    private Specification<Entidad> createSpec(EntidadFindParams params) {
        return new Specification<Entidad>() {
            @Override
            public Predicate toPredicate(Root<Entidad> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(params.getTextoNombre())) {
                    predicates.add(criteriaBuilder.like(root.get("nombre"),
                            "%" + params.getTextoNombre() + "%"));
                }

                if (StringUtils.isNotBlank(params.getEmail())) {
                    predicates.add(criteriaBuilder.equal(root.get("email"), params.getEmail()));
                }

                if (params.getEdad() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("edad"), params.getEdad()));
                } else if (params.getEdadMin() != null && params.getEdadMax() != null) {
                    predicates.add(criteriaBuilder.between(root.get("edad"), params.getEdadMin(),
                            params.getEdadMax()));
                } else if (params.getEdadMin() != null) {
                    predicates.add(criteriaBuilder.ge(root.get("edad"), params.getEdad()));
                } else if (params.getEdadMax() != null) {
                    predicates.add(criteriaBuilder.le(root.get("edad"), params.getEdad()));
                }

                if (params.getIds() != null) {
                    In<Integer> inClause = criteriaBuilder.in(root.get("id"));
                    params.getIds().stream().forEach(id -> inClause.value(id));
                    predicates.add(inClause);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }

}
