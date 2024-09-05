package com.concesionario.repository;

import com.concesionario.persistence.entities.Maker;
import org.springframework.data.repository.CrudRepository;

public interface MakerRepository extends CrudRepository<Maker, Long> {
}
