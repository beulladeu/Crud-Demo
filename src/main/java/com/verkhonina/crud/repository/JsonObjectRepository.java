package com.verkhonina.crud.repository;

import com.verkhonina.crud.model.BaseEntity;
import com.verkhonina.crud.model.Status;

import java.util.LinkedList;
import java.util.List;

public abstract class JsonObjectRepository<T extends BaseEntity> implements GenericRepository<T, Long> {

    private final JsonObjectSupport<T> jsonObjectSupport = new JsonObjectSupport<T>();

    private final String filename;

    private final Class<T[]> listClassType;

    public JsonObjectRepository(String filename, Class<T[]> listClassType) {
        this.filename = filename;
        this.listClassType = listClassType;
    }

    @Override
    public T save(T entity) {
        List<T> objs = readFromFile();

        if (objs == null) {
            objs = new LinkedList<>();
        }

        entity.setId(generateId(objs));
        entity.setStatus(Status.INSERTED);
        objs.add(entity);

        writeToFile(objs);
        return entity;
    }

    @Override
    public T update(T entity) {
        List<T> objs = readFromFile();
        T obj = objs.stream().filter(s -> entity.getId().equals(s.getId())).findFirst().orElse(null);
        if (obj != null && obj.getStatus() != Status.DELETED) {
            entity.setStatus(Status.UPDATED);
            objs.remove(obj);
            objs.add(entity);
            writeToFile(objs);
        }

        return entity;
    }

    @Override
    public T findById(Long id) {
        return readFromFile().stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        List<T> objs = readFromFile();
        T obj = objs.stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
        if (obj != null) {
            obj.setStatus(Status.DELETED);
            writeToFile(objs);
            return true;
        }

        return false;
    }

    @Override
    public List<T> findAll() {
        return readFromFile();
    }

    private void writeToFile(List<T> objs) {
        String jsonObjs = jsonObjectSupport.listToJson(objs);
        jsonObjectSupport.jsonWrite(filename, jsonObjs);
    }

    private List<T> readFromFile() {
        String jsonObjects = jsonObjectSupport.readJson(filename);
        return jsonObjectSupport.jsonToList(jsonObjects, listClassType);
    }

    private Long generateId (List<T> objects) {
        if (objects.isEmpty()) return 0L;
        return objects.stream().mapToLong(BaseEntity::getId).max().stream().findFirst().orElse(0L) + 1;
    }
}
