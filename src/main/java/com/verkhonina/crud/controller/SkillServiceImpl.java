package com.verkhonina.crud.controller;


import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.repository.GsonSkillRepository;

public class SkillServiceImpl implements SkillService {

    private GsonSkillRepository skillRepository;

    public SkillServiceImpl() {
        this.skillRepository = new GsonSkillRepository();
    }


    @Override
    public Skill getById(Long id) {
        return skillRepository.findById(id);
    }


    public Long create(String name) {
        Skill skill = new Skill(name);
        return skillRepository.save(skill);
    }

    @Override
    public boolean delete(Long id) {
        return skillRepository.delete(id);
    }

    @Override
    public boolean update(Skill skill) {
        return skillRepository.update(skill);
    }
}
