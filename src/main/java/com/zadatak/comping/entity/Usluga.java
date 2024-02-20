package com.zadatak.comping.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usluga")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usluga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "opisUsluge")
    private String opisUsluge;

    @ManyToMany
    @JoinTable(
            name = "pruzateljUsluga",
            joinColumns = @JoinColumn(name = "usluga_id"),
            inverseJoinColumns = @JoinColumn(name = "pruzatelj_usluge_id"))
    private Set<PruzateljUsluge> pruzateljiUsluge = new HashSet<>();
}