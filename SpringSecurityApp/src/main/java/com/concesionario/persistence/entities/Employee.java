package com.concesionario.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Person implements Serializable {

    private String charge;
    @OneToOne
    private UserEntity user;
}
