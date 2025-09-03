package com.crudcar.dealership.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "automobile")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String chassiNumber;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String model;

    @Column(name = "car_year", nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Long kilometer;
}
