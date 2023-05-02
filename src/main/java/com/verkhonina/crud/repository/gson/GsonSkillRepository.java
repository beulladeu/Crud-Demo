package com.verkhonina.crud.repository.gson;


import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.repository.JsonObjectRepository;
import com.verkhonina.crud.repository.SkillRepository;

public class GsonSkillRepository extends JsonObjectRepository<Skill> implements SkillRepository {

    private static final String filename = "C:\\Users\\v.verhonina\\Downloads\\skills.json";

    public GsonSkillRepository() {
        super(filename, Skill[].class);
    }
}
