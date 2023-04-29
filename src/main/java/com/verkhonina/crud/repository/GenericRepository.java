package com.verkhonina.crud.repository;


import java.util.List;

public interface GenericRepository<T, ID> {

    ID save(T entity);

    boolean update(T entity);

    T findById(ID id);

    boolean delete(ID id);

    List<T> findAll();

}
