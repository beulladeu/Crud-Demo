package com.verkhonina.crud.model;

public class Skill extends BaseEntity{

    private String name;

    public Skill(String name) {
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
        return "Skill{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                "status='" + super.getStatus() + '\'' +
                '}';
    }
}
