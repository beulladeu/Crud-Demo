package com.verkhonina.crud.repository;


import com.verkhonina.crud.model.Developer;
import com.verkhonina.crud.model.Status;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class JsonObjectCrud<T extends Developer> implements GenericRepository<T, Long> {

    private final JsonObjectSupport<T> jsonObjectSupport;

    private String filename;

    public JsonObjectCrud(String filename) {
        this.filename = filename;
        this.jsonObjectSupport = new JsonObjectSupport<>();
    }


    @Override
    public Long save(T entity) {
        long id = 0L;
        List<T> objs = findAll();
        if(objs != null) {
            id = objs.stream().count();
        } else {
            objs = new LinkedList<>();
        }

        entity.setId(id);
        entity.setStatus(Status.INSERTED);
        objs.add(entity);

        String jsonObjs = jsonObjectSupport.listToJson(objs);
        jsonObjectSupport.jsonWrite(filename, jsonObjs);
        return id;
    }

    @Override
    public boolean update(T entity) {
        List<T> objs = findAll();
        T obj = objs.stream().filter(s -> entity.getId().equals(s.getId())).findFirst().orElse(null);
        if (obj != null && obj.getStatus() != Status.DELETED) {
            entity.setStatus(Status.UPDATED);
            obj = entity;
            String jsonSkills = jsonObjectSupport.listToJson(objs);
            jsonObjectSupport.jsonWrite(filename, jsonSkills);
            return true;
        }

        return false;
    }

    @Override
    public T findById(Long id) {
        return findAll().stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        List<T> objs = findAll();
        T obj = objs.stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
        if (obj != null) {
            obj.setStatus(Status.DELETED);
            String jsonSkills = jsonObjectSupport.listToJson(objs);
            jsonObjectSupport.jsonWrite(filename, jsonSkills);
            return true;
        }

        return false;
    }

    @Override
    public List<T> findAll() {
        String jsonSkills = jsonObjectSupport.readJson(filename);
        //return jsonObjectSupport.jsonToList(jsonSkills, T[].class);
        return Collections.emptyList();
    }
}
