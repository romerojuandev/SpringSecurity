package com.concesionario.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    @Column(name = "user_entity")
    private UserEntity userEntity;
}
