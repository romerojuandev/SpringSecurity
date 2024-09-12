package com.concesionario.repository;

import com.concesionario.persistence.entities.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Long> {
}
