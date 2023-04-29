package com.verkhonina.crud.model;

import java.util.List;

public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Skill> skills;
    private Specialty specialty;
    private Status status;


    public Developer(String firstName, String lastName, List<Skill> skills, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.specialty = specialty;
    }

    public Developer(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
