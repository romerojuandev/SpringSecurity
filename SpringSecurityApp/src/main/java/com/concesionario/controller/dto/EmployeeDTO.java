package com.concesionario.controller.dto;

import com.concesionario.persistence.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO extends PersonDTO{

    private String charge;
    private UserEntity user;
}
