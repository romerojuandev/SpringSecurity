package com.concesionario.service.impl;

import com.concesionario.persistence.entities.Sale;
import com.concesionario.persistence.interfaces.ISaleDAO;
import com.concesionario.service.interfaces.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private ISaleDAO saleDAO;

    @Override
    public List<Sale> findAll() {
        return this.saleDAO.findAll();
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return this.saleDAO.findById(id);
    }

    @Override
    public void save(Sale sale) {
        this.saleDAO.save(sale);
    }

    @Override
    public void deleteById(Long id) {
        this.saleDAO.deleteById(id);
    }
}
