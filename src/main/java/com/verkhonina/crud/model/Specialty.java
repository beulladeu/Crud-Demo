package com.verkhonina.crud.model;

public class Specialty extends BaseEntity {

    private String name;

    public Specialty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id='" + super.getId() + '\'' +
                "status='" + super.getStatus() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}

