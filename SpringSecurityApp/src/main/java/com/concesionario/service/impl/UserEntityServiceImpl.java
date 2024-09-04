package com.concesionario.service.impl;

import com.concesionario.persistence.entities.UserEntity;
import com.concesionario.persistence.interfaces.IUserEntityDAO;
import com.concesionario.service.interfaces.IUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserEntityServiceImpl implements IUserEntityService {

    @Autowired
    private IUserEntityDAO userEntityDAO;

    @Override
    public List<UserEntity> findAll() {
        return userEntityDAO.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userEntityDAO.findById(id);
    }

    @Override
    public void save(UserEntity userEntity) {
        userEntityDAO.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userEntityDAO.deleteById(id);
    }

    @Override
    public void disabledUser(String username) {
        Optional<UserEntity> optionalUser = this.userEntityDAO.findUserEntityByUsername(username);

        if(optionalUser.isPresent()){

            UserEntity user = optionalUser.get();
            user.setEnabled(false);
            user.setAccountNoExpired(false);
            user.setCredentialNoExpired(false);
            user.setAccountNoLocked(false);
            this.userEntityDAO.save(user);
        } else {

            throw new UsernameNotFoundException("Usuario no encontrado.");
        }
    }
}
