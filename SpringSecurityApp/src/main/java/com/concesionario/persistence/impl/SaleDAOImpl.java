package com.concesionario.persistence.impl;

import com.concesionario.persistence.entities.Sale;
import com.concesionario.persistence.interfaces.ISaleDAO;
import com.concesionario.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaleDAOImpl implements ISaleDAO {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> findAll() {
        return (List<Sale>) this.saleRepository.findAll();
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return this.saleRepository.findById(id);
    }

    @Override
    public void save(Sale sale) {
        this.saleRepository.save(sale);
    }

    @Override
    public void deleteById(Long id) {
        this.saleRepository.deleteById(id);
    }
}
