package com.verkhonina.crud.repository.gson;

import com.verkhonina.crud.model.Developer;
import com.verkhonina.crud.repository.DeveloperRepository;
import com.verkhonina.crud.repository.JsonObjectRepository;

public class GsonDeveloperRepository extends JsonObjectRepository<Developer> implements DeveloperRepository {

    private static final String filename = "C:\\Users\\v.verhonina\\Downloads\\developers.json";

    public GsonDeveloperRepository() {
        super(filename, Developer[].class);
    }
}
