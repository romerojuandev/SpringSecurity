package com.concesionario.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    private int mileage;
    private String model;
    private String plate;
    private String color;
    private String engine;
    private BigDecimal price;
    private String description;
    @ManyToOne
    private Maker maker;

}
