package com.dhmi.ais.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "airport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50, nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String IcaoId;

    @Column(length = 50, nullable = false)
    private String IataId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
