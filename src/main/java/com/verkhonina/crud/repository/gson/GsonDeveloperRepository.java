package com.verkhonina.crud.repository.gson;

import com.verkhonina.crud.model.Developer;
import com.verkhonina.crud.repository.DeveloperRepository;
import com.verkhonina.crud.repository.JsonObjectRepository;

public class GsonDeveloperRepository extends JsonObjectRepository<Developer> implements DeveloperRepository {

    public GsonDeveloperRepository() {
        super("C:\\Users\\v.verhonina\\Downloads\\developers.json", Developer[].class);
    }
}
