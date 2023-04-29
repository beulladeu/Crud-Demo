package com.verkhonina.crud.view;

import com.verkhonina.crud.controller.*;
import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.model.Specialty;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Старт");

        SkillService skillService = new SkillServiceImpl();

        Long id = skillService.create("spring");

        Long id2 = skillService.create("sql");

        Skill s = skillService.getById(1L);

        System.out.println(s.getName());

        boolean deleted = skillService.delete(s.getId());

        System.out.println(deleted);

        Skill s2 = skillService.getById(0L);
        s2.setName("java");

        boolean updated = skillService.update(s2);

        System.out.println(updated);

        ///////////

        SpecialtyService specialtyService = new SpecialtyServiceImpl();

        specialtyService.create("Frontend");

        specialtyService.create("Backend");

        Specialty specialty = specialtyService.getById(1L);

        /////////////////////////

        DeveloperService devService = new DeveloperServiceImpl();

        devService.create("Kolin", "Tompson", List.of(s, s2), specialty);

    }
}
