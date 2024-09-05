package com.concesionario.repository;

import com.concesionario.persistence.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository <Vehicle, Long> {
}
