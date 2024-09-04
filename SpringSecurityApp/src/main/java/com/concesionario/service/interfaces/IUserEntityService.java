package com.concesionario.service.interfaces;

import com.concesionario.persistence.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserEntityService {

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    void save(UserEntity userEntity);

    void deleteById(Long id);

    void disabledUser(String username);
}
