package com.verkhonina.crud.controller;

import com.verkhonina.crud.model.Skill;

public interface SkillService {

    Long create(String name);

    Skill getById(Long aLong);

    boolean delete(Long id);

    boolean update(Skill skill);

}
