package com.concesionario.service.impl;

import com.concesionario.persistence.entities.Maker;
import com.concesionario.persistence.interfaces.IMakerDAO;
import com.concesionario.service.interfaces.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<Maker> findAll() {
        return this.makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return this.makerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        this.makerDAO.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        this.makerDAO.deleteById(id);
    }
}
