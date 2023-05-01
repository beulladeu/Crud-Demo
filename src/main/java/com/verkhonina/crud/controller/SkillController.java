package com.verkhonina.crud.controller;

import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.service.SkillService;
import com.verkhonina.crud.service.SkillServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkillController {
    SkillService skillService = new SkillServiceImpl();

    public List<Skill> getSkills(String options) {
        List<Integer> skillIndexes = Arrays.stream(options.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return skillIndexes.stream().map(id -> skillService.getById(id.longValue())).collect(Collectors.toList());
    }

}
