package com.zadatak.comping.specification;

import com.zadatak.comping.entity.Usluga;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UslugaSpecification {

    public static Specification<Usluga> hasProperties(Map<String, Object> properties){
        /* Metoda koja implementira dinamicko filtriranje. root je Root objekt koji predstavlja Usluga entitet
         *  query je CriteriaQuery objekt koji predstavlja query dok je cb CriteriaBuilder objekt koji "konstruira" querry.
         *  Iterira se kroz entrySet i dodaje u predicates koji provjerava je li field (entry.getKey()) jednak value (entry.getValue()).**/
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            for(Map.Entry<String, Object> entry : properties.entrySet()){
                predicates.add(cb.equal(root.get(entry.getKey()), entry.getValue()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}
