package com.concesionario.persistence.interfaces;

import com.concesionario.persistence.entities.Sale;

import java.util.List;
import java.util.Optional;

public interface ISaleDAO {

    List<Sale> findAll();
    Optional<Sale> findById(Long id);
    void save(Sale sale);
    void deleteById(Long id);
}
