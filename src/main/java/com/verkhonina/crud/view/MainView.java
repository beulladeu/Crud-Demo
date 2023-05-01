package com.verkhonina.crud.view;

import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);
    private final SkillView skillView = new SkillView();
    private final SpecialtyView specialtyView = new SpecialtyView();
    private final DeveloperView developerView = new DeveloperView();

    public void start() {
        System.out.println("Enter option you want to work with");
        String option;
        do {
            System.out.println("1 - Create entities");
            System.out.println("2 - Delete entities");
            System.out.println("3 - Update entities");
            System.out.println("4 - Show entities");
            System.out.println("quit - Exit");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    createEntities();
                    break;
                case "2":
                    deleteRecords();
                    break;
                case "3":
                    updateRecord();
                    break;
                case "4":
                    showRecords();
                    break;
                default:
                    break;
            }
        } while (!option.equals("quit"));
    }

    public void createEntities() {
        System.out.println("Enter option you want to create:");
        String option;
        do {
            showEntityOptions();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    specialtyView.createSpecialty();
                    break;
                case "2":
                    skillView.createSkill();
                    break;
                case "3":
                    developerView.createDeveloper();
                    break;
                default:
                    break;
            }
        } while (!option.equals("quit"));
    }

    public void showRecords() {
        System.out.println("Enter option you want to look at:");
        String option;
        do {
            showEntityOptions();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    specialtyView.showAllSpecialties();
                    break;
                case "2":
                    skillView.showAllSkills();
                    break;
                case "3":
                    developerView.showAllDevelopers();
                    break;
                default:
                    break;
            }
        } while (!option.equals("quit"));
    }


    public void deleteRecords() {
        System.out.println("Enter option which record you want to delete:");
        String option;
        do {
            showEntityOptions();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    specialtyView.deleteSpecialty();
                    break;
                case "2":
                    skillView.deleteSkill();
                    break;
                case "3":
                    developerView.deleteDeveloper();
                    break;
                default:
                    break;
            }
        } while (!option.equals("quit"));
    }

    public void updateRecord() {
        System.out.println("Enter option which record you want to update:");
        String option;
        do {
            showEntityOptions();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    specialtyView.updateSpecialty();
                    break;
                case "2":
                    skillView.updateSkill();
                    break;
                case "3":
                    developerView.updateDeveloper();
                    break;
                default:
                    break;
            }
        } while (!option.equals("quit"));

    }

    private void showEntityOptions() {
        System.out.println("1 - Specialty");
        System.out.println("2 - Skill");
        System.out.println("3 - Developer");
        System.out.println("quit - Exit");
    }

}
