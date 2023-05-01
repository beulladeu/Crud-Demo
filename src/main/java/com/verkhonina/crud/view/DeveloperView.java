package com.verkhonina.crud.view;

import com.verkhonina.crud.model.Developer;
import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.service.DeveloperService;
import com.verkhonina.crud.service.DeveloperServiceImpl;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DeveloperView {
    private final Scanner scanner = new Scanner(System.in);
    private final DeveloperService developerService = new DeveloperServiceImpl();
    private final SkillView skillView = new SkillView();
    private final SpecialtyView specialtyView = new SpecialtyView();

    public void createDeveloper() {
        System.out.println("Enter developer first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter developer last name:");
        String lastName = scanner.nextLine();
        List<Skill> skills = skillView.chooseOrAddSkills();
        Specialty specialties = specialtyView.chooseOrAddSpecialty();
        Developer createdDeveloper = developerService.create(firstName, lastName, skills, specialties);
        System.out.println("Created developer: " + createdDeveloper);
    }

    public void showAllDevelopers() {
        System.out.println("All developers:");
        List<Developer> developers = developerService.getAll();
        IntStream.range(0, developers.size())
                .forEach(index -> System.out.println(String.format("[%d] : %s", index, developers.get(index))));
    }

    public void deleteDeveloper() {
        System.out.println("Enter developer option to delete");
        showAllDevelopers();
        Long option = scanner.nextLong();
        boolean isDeleted = developerService.delete(option);
        if (isDeleted) System.out.println("Record is successfully deleted");
        else System.out.println("Record isn't deleted");
    }

    public void updateDeveloper() {
        System.out.println("Enter developer option to update");
        showAllDevelopers();

        Long id = scanner.nextLong();
        Developer developer = developerService.getById(id);
        scanner.nextLine();

        String option;
        do {
            showDeveloperField();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Enter new developer name:");
                    developer.setFirstName(scanner.nextLine());
                    break;
                case "2":
                    System.out.println("Enter last developer name:");
                    developer.setFirstName(scanner.nextLine());
                    break;
                case "3":
                    developer.setSpecialty(specialtyView.chooseOrAddSpecialty());
                    break;
                case "4":
                    developer.setSkills(skillView.chooseOrAddSkills());
                    break;
                default:
                    break;
            }
        } while (!option.equals("quit"));

        Developer updatedDeveloper = developerService.update(developer);
        System.out.println("Updated developer: " + updatedDeveloper);
    }

    private void showDeveloperField() {
        System.out.println("1 - First name");
        System.out.println("2 - Last name");
        System.out.println("3 - Specialty");
        System.out.println("4 - Skills");
        System.out.println("quit - Exit");
    }

}
