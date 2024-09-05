package com.concesionario.controller.dto;

import com.concesionario.persistence.entities.Maker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    private Long id;
    private String model;
    private String plate;
    private int mileage;
    private String year;
    private BigDecimal price;
    private String color;
    private String engine;
    private String description;
    private Maker maker;
}
