package com.verkhonina.crud.repository.gson;


import com.verkhonina.crud.model.Specialty;
import com.verkhonina.crud.repository.JsonObjectRepository;
import com.verkhonina.crud.repository.SpecialtyRepository;

public class GsonSpecialtyRepository extends JsonObjectRepository<Specialty> implements SpecialtyRepository {

    public GsonSpecialtyRepository() {
        super("C:\\Users\\v.verhonina\\Downloads\\specialties.json", Specialty[].class);
    }
}
