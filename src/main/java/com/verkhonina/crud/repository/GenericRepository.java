package com.verkhonina.crud.repository;


import java.util.List;

public interface GenericRepository<T, ID> {

    T save(T entity);

    T update(T entity);

    T findById(ID id);

    boolean delete(ID id);

    List<T> findAll();

}
