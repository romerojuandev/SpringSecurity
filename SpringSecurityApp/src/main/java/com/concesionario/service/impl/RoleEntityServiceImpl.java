package com.concesionario.service.impl;

import com.concesionario.persistence.entities.RoleEntity;
import com.concesionario.persistence.interfaces.IRoleEntityDAO;
import com.concesionario.service.interfaces.IRoleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleEntityServiceImpl implements IRoleEntityService {

    @Autowired
    private IRoleEntityDAO roleEntityDAO;

    @Override
    public List<RoleEntity> findAll() {
        return roleEntityDAO.findAll();
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {
        return roleEntityDAO.findById(id);
    }

    @Override
    public void save(RoleEntity roleEntity) {
        roleEntityDAO.save(roleEntity);
    }

    @Override
    public void deleteById(Long id) {
        roleEntityDAO.deleteById(id);
    }
}
