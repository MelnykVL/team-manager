package com.melnykvl.teammanager.repository;

import com.melnykvl.teammanager.model.Developer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private final File file = new File("src/main/resources/developers.txt");

    public JavaIODeveloperRepositoryImpl() {

        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Developer getById(Integer integer) {
        return null;
    }

    @Override
    public Developer add(Developer developer) {
        return null;
    }

    @Override
    public Developer update(Developer developer) {
        return null;
    }

    @Override
    public void removeById(Integer integer) {

    }

    @Override
    public List<Developer> getAll() {
        return null;
    }
}
