package com.concesionario.service.impl;

import com.concesionario.persistence.entities.Vehicle;
import com.concesionario.persistence.interfaces.IVehicleDAO;
import com.concesionario.service.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleDAO vehicleDAO;

    @Override
    public List<Vehicle> findAll() {
        return this.vehicleDAO.findAll();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return this.vehicleDAO.findById(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        this.vehicleDAO.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        this.vehicleDAO.deleteById(id);
    }
}
