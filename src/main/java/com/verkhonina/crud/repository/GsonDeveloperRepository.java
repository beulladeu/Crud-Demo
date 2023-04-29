package com.verkhonina.crud.repository;

import com.verkhonina.crud.model.Developer;
import com.verkhonina.crud.model.Status;

import java.util.LinkedList;
import java.util.List;

public class GsonDeveloperRepository implements DeveloperRepository {

    private final String devsFileName = "C:\\Users\\v.verhonina\\Downloads\\developers.json";

    private final JsonObjectSupport<Developer> jsonObjectSupport;

    public GsonDeveloperRepository() {
        this.jsonObjectSupport = new JsonObjectSupport<>();
    }


    @Override
    public Long save(Developer entity) {
        long id = 0L;
        List<Developer> devs = findAll();
        if(devs != null) {
            id = devs.stream().count();
        } else {
            devs = new LinkedList<>();
        }

        entity.setId(id);
        entity.setStatus(Status.INSERTED);
        devs.add(entity);

        String jsonDevs = jsonObjectSupport.listToJson(devs);
        jsonObjectSupport.jsonWrite(devsFileName, jsonDevs);
        return id;
    }

    @Override
    public boolean update(Developer entity) {
        List<Developer> devs = findAll();
        Developer dev = devs.stream().filter(s -> entity.getId().equals(s.getId())).findFirst().orElse(null);
        if (dev != null && dev.getStatus() != Status.DELETED) {
            entity.setStatus(Status.UPDATED);
            dev = entity;
            String jsonDevs = jsonObjectSupport.listToJson(devs);
            jsonObjectSupport.jsonWrite(devsFileName, jsonDevs);
            return true;
        }

        return false;
    }

    @Override
    public Developer findById(Long id) {
        return findAll().stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        List<Developer> devs = findAll();
        Developer developer = devs.stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
        if (developer != null) {
            developer.setStatus(Status.DELETED);
            String jsonDevs = jsonObjectSupport.listToJson(devs);
            jsonObjectSupport.jsonWrite(devsFileName, jsonDevs);
            return true;
        }

        return false;
    }

    @Override
    public List<Developer> findAll() {
        String jsonSkills = jsonObjectSupport.readJson(devsFileName);
        return jsonObjectSupport.jsonToList(jsonSkills, Developer[].class);
    }
}
