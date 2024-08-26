package com.concesionario.persistence.impl;

import com.concesionario.persistence.entities.Person;
import com.concesionario.persistence.interfaces.IPersonDAO;
import com.concesionario.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return (List<Person>) this.personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return this.personRepository.findById(id);
    }

    @Override
    public void save(Person person) {
        this.personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        this.personRepository.deleteById(id);
    }
}
