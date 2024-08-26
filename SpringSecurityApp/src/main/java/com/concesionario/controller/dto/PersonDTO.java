package com.concesionario.controller.dto;

import com.concesionario.persistence.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String lastName;
    private UserEntity userEntity;
}
