package com.melnykvl.teammanager.repository;

import com.google.gson.Gson;
import com.melnykvl.teammanager.model.Skill;
import com.melnykvl.teammanager.model.Team;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SkillRepository implements Repository<Skill, Integer> {

    private final File file = new File("src/main/resources/skills.txt");
    Gson gson = new Gson();

    public SkillRepository() {

        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Skill get(Integer integer) {
        return null;
    }

    @Override
    public void add(Skill skill) {

    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void remove(Skill skill) {

    }

    @Override
    public List<Skill> getAll() {
        return null;
    }
}
