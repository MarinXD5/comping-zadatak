package com.zadatak.comping.specification;

import com.zadatak.comping.entity.ServiceProvider;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceProviderSpecification {

    public static Specification<ServiceProvider> hasProperties(Map<String, Object> properties){
        /* Method that implements dynamic filtering. root is a Root object that represents Service entity. Query is a
           CriteriaQuery object which represents a query, while the cb is a CriteriaBuilder object which constructs a query.
           The for loop iterates through entrySet and adds to predicates list those cbs whose entry.getKey() is equal to entry.getValue() fields **/
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            for(Map.Entry<String, Object> entry : properties.entrySet()){
                predicates.add(cb.equal(root.get(entry.getKey()), entry.getValue()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}

