package com.concesionario.persistence.impl;

import com.concesionario.persistence.entities.RoleEntity;
import com.concesionario.persistence.interfaces.IRoleEntityDAO;
import com.concesionario.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleEntityDAOImpl implements IRoleEntityDAO {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> findAll() {
        return (List<RoleEntity>) roleRepository.findAll();
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
