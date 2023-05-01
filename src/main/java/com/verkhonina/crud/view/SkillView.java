package com.verkhonina.crud.view;

import com.verkhonina.crud.controller.SkillController;
import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.service.SkillService;
import com.verkhonina.crud.service.SkillServiceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SkillView {
    private final SkillService skillService = new SkillServiceImpl();
    private final Scanner scanner = new Scanner(System.in);
    private final SkillController skillController = new SkillController();

    public Skill createSkill() {
        System.out.println("Enter skill name:");
        String name = scanner.nextLine();
        Skill createdSkill = skillService.create(name);
        System.out.println("Created skill: " + createdSkill);
        return createdSkill;
    }

    public void showAllSkills() {
        System.out.println("All skills:");
        List<Skill> skills = skillService.getAll();
        IntStream.range(0, skills.size())
                .forEach(index -> System.out.println(String.format("[%d] : %s", index, skills.get(index))));
    }

    public List<Skill> getChosenSkills() {
        System.out.println("Enter skill options separated commas without spaces");
        showAllSkills();
        String options = scanner.nextLine();
        return skillController.getSkills(options);
    }

    public List<Skill> chooseOrAddSkills() {
        List<Skill> skills = new LinkedList<>();
        if (!skillService.getAll().isEmpty()) {
            skills = getChosenSkills();
        } else {
            System.out.println("Create skill of developer:");
            skills.add(createSkill());
        }
        System.out.println("Skills:");
        System.out.println(skills);
        return skills;
    }

    public void deleteSkill() {
        System.out.println("Enter skill option to delete");
        showAllSkills();
        Long option = scanner.nextLong();
        boolean isDeleted = skillService.delete(option);
        if (isDeleted) System.out.println("Record is successfully deleted");
        else System.out.println("Record isn't deleted");
    }

    public void updateSkill() {
        System.out.println("Enter skill option to update");
        showAllSkills();
        Long option = scanner.nextLong();
        Skill skill = skillService.getById(option);
        scanner.nextLine();
        System.out.println("Enter new skill name:");
        String name = scanner.nextLine();
        skill.setName(name);
        Skill updatedSkill = skillService.update(skill);
        System.out.println("Updated skill: " + updatedSkill);
    }
}
