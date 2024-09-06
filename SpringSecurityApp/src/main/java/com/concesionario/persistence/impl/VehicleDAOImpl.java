package com.concesionario.persistence.impl;

import com.concesionario.persistence.entities.Vehicle;
import com.concesionario.persistence.interfaces.IVehicleDAO;
import com.concesionario.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleDAOImpl implements IVehicleDAO {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return (List<Vehicle>) this.vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return this.vehicleRepository.findById(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        this.vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        this.vehicleRepository.deleteById(id);
    }
}
