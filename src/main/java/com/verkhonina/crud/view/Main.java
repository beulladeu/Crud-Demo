package com.verkhonina.crud.view;

import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.service.*;
import com.verkhonina.crud.model.Skill;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Старт");

        SkillService skillService = new SkillServiceImpl();

        Skill id = skillService.create("spring");

        Skill id2 = skillService.create("sql");

        Skill s = skillService.getById(1L);

        System.out.println(s.getName());
        List<Skill> skills = skillService.getAll();
        System.out.println(s);


        boolean deleted = skillService.delete(s.getId());

        System.out.println(deleted);

        Skill s2 = skillService.getById(0L);
        s2.setName("java");

        Skill updated = skillService.update(s2);

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
