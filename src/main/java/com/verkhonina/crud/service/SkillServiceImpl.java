package com.verkhonina.crud.service;


import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.repository.SkillRepository;
import com.verkhonina.crud.repository.gson.*;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;

    public SkillServiceImpl() {
        this.skillRepository = new GsonSkillRepository();
    }


    @Override
    public Skill getById(Long id) {
        return skillRepository.findById(id);
    }


    public Skill create(String name) {
        Skill skill = new Skill(name);
        return skillRepository.save(skill);
    }

    @Override
    public boolean delete(Long id) {
        return skillRepository.delete(id);
    }

    @Override
    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }
}
