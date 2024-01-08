package com.dhmi.ais.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50, nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

//    @Column(length = 50, nullable = false)
//    private String code;

    @OneToMany(mappedBy = "country")
    private Set<Airport> airports;
}
