package com.concesionario.controller.dto;

import com.concesionario.persistence.entities.Employee;
import com.concesionario.persistence.entities.Person;
import com.concesionario.persistence.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private Long id;
    private Person customer;
    private Employee employee;
    private Vehicle vehicle;
    private LocalDate date;
    private BigDecimal amount;
    private String description;
}
