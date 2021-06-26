package com.melnykvl.teammanager.repository;

import com.google.gson.Gson;
import com.melnykvl.teammanager.model.Team;

import java.io.*;
import java.util.List;

public class TeamRepository implements Repository<Team, Integer> {

    private final File file = new File("src/main/resources/teams.txt");
    Gson gson = new Gson();

    public TeamRepository() {

        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Team get(Integer integer) {
        return null;
    }

    @Override
    public void add(Team team) {

    }

    @Override
    public void update(Team team) {

    }

    @Override
    public void remove(Team team) {

    }

    @Override
    public List<Team> getAll() {
        return null;
    }

}
