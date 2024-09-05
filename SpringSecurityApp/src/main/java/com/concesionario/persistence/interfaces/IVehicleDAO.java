package com.concesionario.persistence.interfaces;

import com.concesionario.persistence.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleDAO {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(Long id);
    void save(Vehicle vehicle);
    void deleteById(Long id);
}
