package com.concesionario.controller.dto;

import com.concesionario.persistence.entities.PermissionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntityDTO {

    private Long id;
    private String name;
    private Set<PermissionEntity> permissionList = new HashSet<>();
}
