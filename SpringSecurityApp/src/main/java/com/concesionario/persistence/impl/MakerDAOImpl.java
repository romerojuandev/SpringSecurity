package com.concesionario.persistence.impl;

import com.concesionario.persistence.entities.Maker;
import com.concesionario.persistence.interfaces.IMakerDAO;
import com.concesionario.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) this.makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return this.makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        this.makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        this.makerRepository.deleteById(id);
    }
}
