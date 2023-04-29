package com.verkhonina.crud.repository;


import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.model.Status;
import java.util.LinkedList;
import java.util.List;

public class GsonSpecialtyRepository implements SpecialtyRepository {

    private final String specialtiesFileName = "C:\\Users\\v.verhonina\\Downloads\\specialties.json";

    private final JsonObjectSupport<Specialty> jsonObjectSupport;

    public GsonSpecialtyRepository() {
        this.jsonObjectSupport = new JsonObjectSupport<>();
    }


    @Override
    public Long save(Specialty entity) {
        long id = 0L;
        List<Specialty> specialty = findAll();
        if(specialty != null) {
            id = specialty.stream().count();
        } else {
            specialty = new LinkedList<>();
        }

        entity.setId(id);
        entity.setStatus(Status.INSERTED);
        specialty.add(entity);

        String jsonSpecialties = jsonObjectSupport.listToJson(specialty);
        jsonObjectSupport.jsonWrite(specialtiesFileName, jsonSpecialties);
        return id;
    }

    @Override
    public boolean update(Specialty entity) {
        List<Specialty> specialties = findAll();
        Specialty specialty = specialties.stream().filter(s -> entity.getId().equals(s.getId())).findFirst().orElse(null);
        if (specialty != null && specialty.getStatus() != Status.DELETED) {
            entity.setStatus(Status.UPDATED);
            specialty = entity;
            String jsonDevs = jsonObjectSupport.listToJson(specialties);
            jsonObjectSupport.jsonWrite(specialtiesFileName, jsonDevs);
            return true;
        }

        return false;
    }

    @Override
    public Specialty findById(Long id) {
        return findAll().stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        List<Specialty> skills = findAll();
        Specialty specialty = skills.stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
        if (specialty != null) {
            specialty.setStatus(Status.DELETED);
            String jsonSkills = jsonObjectSupport.listToJson(skills);
            jsonObjectSupport.jsonWrite(specialtiesFileName, jsonSkills);
            return true;
        }

        return false;
    }

    @Override
    public List<Specialty> findAll() {
        String jsonSkills = jsonObjectSupport.readJson(specialtiesFileName);
        return jsonObjectSupport.jsonToList(jsonSkills, Specialty[].class);
    }
}
