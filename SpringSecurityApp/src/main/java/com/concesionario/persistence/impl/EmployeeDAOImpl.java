package com.concesionario.persistence.impl;

import com.concesionario.persistence.entities.Employee;
import com.concesionario.persistence.interfaces.IEmployeeDAO;
import com.concesionario.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) this.employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
