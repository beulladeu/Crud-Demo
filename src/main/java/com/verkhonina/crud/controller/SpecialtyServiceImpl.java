package com.verkhonina.crud.controller;

import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.repository.GsonSpecialtyRepository;
import com.verkhonina.crud.repository.SpecialtyRepository;

public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl() {
        this.specialtyRepository = new GsonSpecialtyRepository();
    }

    @Override
    public Specialty getById(Long id) {
        return specialtyRepository.findById(id);
    }

    @Override
    public Long create(String name) {
        Specialty specialty = new Specialty(name);
        return specialtyRepository.save(specialty);
    }

    @Override
    public boolean delete(Long id) {
        return specialtyRepository.delete(id);
    }

    @Override
    public boolean update(Specialty specialty) {
        return specialtyRepository.update(specialty);
    }
}
