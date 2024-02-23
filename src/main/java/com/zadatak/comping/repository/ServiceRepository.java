package com.zadatak.comping.repository;

import com.zadatak.comping.entity.Service;
import com.zadatak.comping.projections.ServiceDescriptionProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(collectionResourceRel = "services", path="services")
@Transactional
public interface ServiceRepository extends JpaRepository<Service, Long>, JpaSpecificationExecutor<Service> {
    @Query("SELECT s.serviceDescription AS serviceDescription FROM Service s")
    List<ServiceDescriptionProjection> findAllServiceDescription();

    @Query("SELECT s FROM Service s LEFT JOIN FETCH s.serviceProviders WHERE s.id = :id")
    Optional<Service> findByIdWithProviders(@Param("id") Long id);

}