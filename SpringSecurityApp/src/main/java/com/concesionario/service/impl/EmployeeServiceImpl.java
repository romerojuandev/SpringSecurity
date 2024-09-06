package com.concesionario.service.impl;

import com.concesionario.persistence.entities.Employee;
import com.concesionario.persistence.interfaces.IEmployeeDAO;
import com.concesionario.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeDAO.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        this.employeeDAO.deleteById(id);
    }
}
