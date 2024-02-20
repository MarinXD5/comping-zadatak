package com.zadatak.comping.entity;

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
public class PruzateljUsluge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nazivPruzatelja")
    private String nazivPruzatelja;

    @ManyToMany(mappedBy = "pruzateljiUsluge")
    private Set<Usluga> usluge = new HashSet<>();
}