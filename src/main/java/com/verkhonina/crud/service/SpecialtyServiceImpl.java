package com.verkhonina.crud.service;

import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.repository.SpecialtyRepository;
import com.verkhonina.crud.repository.gson.*;

import java.util.List;

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
    public Specialty create(String name) {
        Specialty specialty = new Specialty(name);
        return specialtyRepository.save(specialty);
    }

    @Override
    public boolean delete(Long id) {
        return specialtyRepository.delete(id);
    }

    @Override
    public Specialty update(Specialty specialty) {
        return specialtyRepository.update(specialty);
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }
}
