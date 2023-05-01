package com.verkhonina.crud.service;

import com.verkhonina.crud.model.Specialty;
import java.util.List;

public interface SpecialtyService {

    Specialty getById(Long id);

    Specialty create(String name);

    boolean delete(Long id);

    Specialty update(Specialty specialty);

    List<Specialty> getAll();

}
