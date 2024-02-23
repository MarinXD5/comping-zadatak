package com.zadatak.comping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "serviceProvider")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="service_provider_id")
    private Long id;

    @Column(name="providerName")
    private String providerName;

    @ManyToMany(mappedBy = "serviceProviders", fetch = FetchType.EAGER)
    private Set<Service> services = new HashSet<>();
}