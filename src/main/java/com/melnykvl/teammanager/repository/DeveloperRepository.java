package com.melnykvl.teammanager.repository;

import com.melnykvl.teammanager.model.Developer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DeveloperRepository implements Repository<Developer, Integer> {

    private final File file = new File("src/main/resources/developers.txt");

    public DeveloperRepository() {

        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Developer get(Integer integer) {
        return null;
    }

    @Override
    public void add(Developer developer) {

    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void remove(Developer developer) {

    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

}
