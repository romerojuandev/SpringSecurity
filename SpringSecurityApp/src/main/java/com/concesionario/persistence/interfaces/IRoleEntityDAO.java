package com.concesionario.persistence.interfaces;

import com.concesionario.persistence.entities.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface IRoleEntityDAO {

    List<RoleEntity> findAll();

    Optional<RoleEntity> findById(Long id);

    void save(RoleEntity roleEntity);

    void deleteById(Long id);
}
