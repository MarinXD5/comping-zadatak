package com.zadatak.comping.repository;

import com.zadatak.comping.entity.Usluga;
import com.zadatak.comping.projections.UslugaOpisProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "usluge", path="usluge")
public interface UslugaRepository extends JpaRepository<Usluga, Long>, JpaSpecificationExecutor<Usluga> {

    @Query("SELECT u.opisUsluge AS opisUsluge FROM Usluga u")
    List<UslugaOpisProjection> findAllOpisUsluge();

}
