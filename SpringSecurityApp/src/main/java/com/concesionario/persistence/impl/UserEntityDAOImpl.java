package com.concesionario.persistence.impl;

import com.concesionario.persistence.entities.UserEntity;
import com.concesionario.persistence.interfaces.IUserEntityDAO;
import com.concesionario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityDAOImpl implements IUserEntityDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findUserEntityByUsername(String username) {
        return this.userRepository.findUserEntityByUsername(username);
    }
}
