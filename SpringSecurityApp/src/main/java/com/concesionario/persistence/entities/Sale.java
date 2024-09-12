package com.concesionario.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Person customer;
    private Employee employee;
    private Vehicle vehicle;
    private String description;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    private BigDecimal amount;
}
