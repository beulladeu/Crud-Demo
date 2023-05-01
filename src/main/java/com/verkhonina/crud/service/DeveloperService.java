package com.verkhonina.crud.service;

import com.verkhonina.crud.model.Developer;
import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.model.Specialty;

import java.util.List;

public interface DeveloperService {

    Developer getDeveloperByName(String firstName, String lastName);

    Developer create(String firstName, String lastName, List<Skill> skills, Specialty specialty);

    Developer getById(Long id);

    boolean delete(Long id);

    Developer update(Developer developer);

    List<Developer> getAll();
}
