package com.melnykvl.teammanager.repository.implementation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.melnykvl.teammanager.model.Team;
import com.melnykvl.teammanager.repository.TeamRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavaIOTeamRepositoryImpl implements TeamRepository {

    private static int counter;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final File file = new File("src/main/resources/teams.json");

    @Override
    public Team getById(Integer id) {
        return getAll().stream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    @Override
    public Team add(Team team) {

        List<Team> list = getAll();

        counter = list.size() != 0 ? list.get(list.size()-1).getId() : 0;

        team.setId(++counter);

        list.add(team);

        rewriteFile(list);

        return team;
    }

    @Override
    public Team update(Team team) {

        List<Team> list = getAll();

        Team temp = list.stream().filter(n -> n.getId() == team.getId()).findAny().get();

        list.set(list.indexOf(temp), team);

        rewriteFile(list);

        return team;

    }

    @Override
    public void removeById(Integer id) {

        List<Team> list = getAll();

        Team temp = list.stream().filter(n -> n.getId() == id).findAny().orElse(null);

        list.remove(temp);

        rewriteFile(list);

    }

    @Override
    public List<Team> getAll() {

        Optional<List<Team>> opt = Optional.empty();
        Type listTeamType = new TypeToken<ArrayList<Team>>(){}.getType();

        try (Reader reader = Files.newBufferedReader(file.toPath())) {

            opt = Optional.ofNullable(gson.fromJson(reader, listTeamType));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return opt.orElse(new ArrayList<>());

    }

    private void rewriteFile(List<Team> list) {

        try (Writer writer = Files.newBufferedWriter(file.toPath())) {

            gson.toJson(list, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
