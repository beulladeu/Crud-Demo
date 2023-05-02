package com.verkhonina.crud.repository.gson;


import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.repository.JsonObjectRepository;
import com.verkhonina.crud.repository.SpecialtyRepository;

public class GsonSpecialtyRepository extends JsonObjectRepository<Specialty> implements SpecialtyRepository {

    private static final String filename = "C:\\Users\\v.verhonina\\Downloads\\specialties.json";

    public GsonSpecialtyRepository() {
        super(filename, Specialty[].class);
    }
}
