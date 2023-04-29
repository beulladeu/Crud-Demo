package com.verkhonina.crud.controller;

import com.verkhonina.crud.model.Specialty;

public interface SpecialtyService {

    Specialty getById(Long id);

    Long create(String name);

    boolean delete(Long id);

    boolean update(Specialty specialty);

}
