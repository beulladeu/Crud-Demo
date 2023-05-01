package com.verkhonina.crud.service;

import com.verkhonina.crud.model.Skill;

import java.util.List;

public interface SkillService {

    Skill create(String name);

    Skill getById(Long aLong);

    boolean delete(Long id);

    Skill update(Skill skill);

    List<Skill> getAll();

}
