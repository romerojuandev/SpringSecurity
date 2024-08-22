package com.concesionario.service.interfaces;

import com.concesionario.persistence.entities.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface IRoleEntityService {

    List<RoleEntity> findAll();

    Optional<RoleEntity> findById(Long id);

    void save(RoleEntity roleEntity);

    void deleteById(Long id);
}
