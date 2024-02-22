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
@Table(name="usluga")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Usluga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "opisUsluge")
    private String opisUsluge;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "pruzateljUsluga",
            joinColumns = @JoinColumn(name = "usluga_id"),
            inverseJoinColumns = @JoinColumn(name = "pruzatelj_usluge_id"))
    private Set<PruzateljUsluge> pruzateljiUsluge = new HashSet<>();
}