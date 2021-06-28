package com.melnykvl.teammanager.repository;

import com.melnykvl.teammanager.model.Skill;

import java.io.File;
import java.io.IOException;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private final File file = new File("src/main/resources/skills.txt");

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

}
