package com.concesionario.repository;

import com.concesionario.persistence.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
