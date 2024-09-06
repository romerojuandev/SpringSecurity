package com.concesionario.controller.dto;

import com.concesionario.persistence.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Date birthDate;
    private String address;
    private String identity;
    private String lastName;
}
