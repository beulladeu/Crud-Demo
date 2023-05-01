package com.verkhonina.crud.view;

import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.service.SpecialtyService;
import com.verkhonina.crud.service.SpecialtyServiceImpl;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SpecialtyView {
    private final SpecialtyService specialtyService = new SpecialtyServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public Specialty createSpecialty() {
        System.out.println("Enter specialty name:");
        String name = scanner.nextLine();
        Specialty createdSpecialty = specialtyService.create(name);
        System.out.println("Created specialty: " + createdSpecialty);
        return createdSpecialty;
    }

    public void showAllSpecialties() {
        System.out.println("All specialties:");
        List<Specialty> specialties = specialtyService.getAll();
        IntStream.range(0, specialties.size())
                .forEach(index -> System.out.println(String.format("[%d] : %s", index, specialties.get(index))));
    }

    public Specialty getChosenSpecialty() {
        System.out.println("Enter specialty option");
        showAllSpecialties();
        Long option = scanner.nextLong();
        return specialtyService.getById(option);
    }

    public Specialty chooseOrAddSpecialty() {
        Specialty specialty;
        if (!specialtyService.getAll().isEmpty()) {
            specialty = getChosenSpecialty();
        } else {
            System.out.println("Create specialty of developer:");
            specialty = createSpecialty();
        }
        System.out.println("Specialty:");
        System.out.println(specialty);
        return specialty;
    }

    public void deleteSpecialty() {
        System.out.println("Enter specialty option to delete");
        showAllSpecialties();
        Long option = scanner.nextLong();
        boolean isDeleted = specialtyService.delete(option);
        if (isDeleted) System.out.println("Record is successfully deleted");
        else System.out.println("Record isn't deleted");
    }

    public void updateSpecialty() {
        System.out.println("Enter specialty option to update");
        Specialty specialty = getChosenSpecialty();
        scanner.nextLine();
        System.out.println("Enter new specialty name:");
        String name = scanner.nextLine();
        specialty.setName(name);
        Specialty updatedSpecialty = specialtyService.update(specialty);
        System.out.println("Updated specialty: " + updatedSpecialty);
    }
}
