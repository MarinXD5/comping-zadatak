package com.zadatak.comping.repository;

import com.zadatak.comping.entity.PruzateljUsluge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "pruzateljiUsluga", path="pruzateljiUsluga")
public interface PruzateljUslugaRepository extends JpaRepository<PruzateljUsluge, Long>, JpaSpecificationExecutor<PruzateljUsluge> {
}
