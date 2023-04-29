package com.verkhonina.crud.controller;

import com.verkhonina.crud.model.Developer;
import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.repository.DeveloperRepository;
import com.verkhonina.crud.repository.GsonDeveloperRepository;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperRepository developerRepository;

    public DeveloperServiceImpl() {
        this.developerRepository = new GsonDeveloperRepository();
    }

    @Override
    public Developer getDeveloperByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Developer getById(Long id) {
        return developerRepository.findById(id);
    }

    @Override
    public Long create(String firstName, String lastName, List<Skill> skills, Specialty specialty) {
        Developer dev = new Developer(firstName, lastName, skills, specialty);
        return developerRepository.save(dev);
    }

    @Override
    public boolean delete(Long id) {
        return developerRepository.delete(id);
    }

    @Override
    public boolean update(Developer developer) {
        return developerRepository.update(developer);
    }
}
