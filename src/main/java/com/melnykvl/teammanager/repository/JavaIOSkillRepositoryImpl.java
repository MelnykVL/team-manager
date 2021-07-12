package com.melnykvl.teammanager.repository;

import com.melnykvl.teammanager.model.Skill;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private final File file = new File("src/main/resources/skills.json");

    public JavaIOSkillRepositoryImpl() {

        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Skill getById(Integer integer) {
        return null;
    }

    @Override
    public Skill add(Skill skill) {
        return null;
    }

    @Override
    public Skill update(Skill skill) {
        return null;
    }

    @Override
    public void removeById(Integer integer) {

    }

    @Override
    public List<Skill> getAll() {
        return null;
    }
}
