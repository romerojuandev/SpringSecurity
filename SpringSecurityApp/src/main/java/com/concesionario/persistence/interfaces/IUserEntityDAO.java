package com.concesionario.persistence.interfaces;

import com.concesionario.persistence.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserEntityDAO {

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    void save(UserEntity userEntity);

    void deleteById(Long id);
}
