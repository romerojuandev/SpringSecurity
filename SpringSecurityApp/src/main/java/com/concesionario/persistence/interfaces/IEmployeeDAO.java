package com.concesionario.persistence.interfaces;

import com.concesionario.persistence.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDAO {

    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    void save(Employee employee);
    void deleteById(Long id);
}
