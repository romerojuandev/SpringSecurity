package com.concesionario.service.impl;

import com.concesionario.persistence.entities.Person;
import com.concesionario.persistence.interfaces.IPersonDAO;
import com.concesionario.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDAO personDAO;

    @Override
    public List<Person> findAll() {
        return this.personDAO.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return this.personDAO.findById(id);
    }

    @Override
    public void save(Person person) {
        this.personDAO.save(person);
    }

    @Override
    public void deleteById(Long id) {
        this.personDAO.deleteById(id);
    }
}
