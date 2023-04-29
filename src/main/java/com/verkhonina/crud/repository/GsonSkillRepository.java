package com.verkhonina.crud.repository;


import com.verkhonina.crud.model.Skill;
import com.verkhonina.crud.model.Status;
import java.util.LinkedList;
import java.util.List;

public class GsonSkillRepository implements SkillRepository {

    private final JsonObjectSupport<Skill> jsonObjectSupport;

    private final String skillsFileName = "C:\\Users\\v.verhonina\\Downloads\\skills.json";

    public GsonSkillRepository() {
        this.jsonObjectSupport = new JsonObjectSupport<>();
    }


    @Override
    public Long save(Skill entity) {
        long id = 0L;
        List<Skill> skills = findAll();
        if(skills != null) {
            id = skills.stream().count();
        } else {
            skills = new LinkedList<>();
        }

        entity.setId(id);
        entity.setStatus(Status.INSERTED);
        skills.add(entity);

        String jsonSkills = jsonObjectSupport.listToJson(skills);
        jsonObjectSupport.jsonWrite(skillsFileName, jsonSkills);
        return id;
    }

    @Override
    public boolean update(Skill entity) {
        List<Skill> skills = findAll();
        Skill skill = skills.stream().filter(s -> entity.getId().equals(s.getId())).findFirst().orElse(null);
        if (skill != null && skill.getStatus() != Status.DELETED) {
            entity.setStatus(Status.UPDATED);
            skill = entity;
            String jsonSkills = jsonObjectSupport.listToJson(skills);
            jsonObjectSupport.jsonWrite(skillsFileName, jsonSkills);
            return true;
        }

        return false;
    }

    @Override
    public Skill findById(Long id) {
        return findAll().stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        List<Skill> skills = findAll();
        Skill skill = skills.stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
        if (skill != null) {
            skill.setStatus(Status.DELETED);
            String jsonSkills = jsonObjectSupport.listToJson(skills);
            jsonObjectSupport.jsonWrite(skillsFileName, jsonSkills);
            return true;
        }

        return false;
    }

    @Override
    public List<Skill> findAll() {
        String jsonSkills = jsonObjectSupport.readJson(skillsFileName);
        return jsonObjectSupport.jsonToList(jsonSkills, Skill[].class);
    }
}
