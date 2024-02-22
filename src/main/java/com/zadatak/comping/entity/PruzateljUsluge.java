package com.zadatak.comping.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pruzateljUsluge")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PruzateljUsluge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nazivPruzatelja")
    private String nazivPruzatelja;

    @ManyToMany(mappedBy = "pruzateljiUsluge", fetch = FetchType.EAGER)
    private Set<Usluga> usluge = new HashSet<>();
}