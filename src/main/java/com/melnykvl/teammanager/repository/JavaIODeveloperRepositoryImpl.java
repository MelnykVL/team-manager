package com.melnykvl.teammanager.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.melnykvl.teammanager.model.Developer;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private static int counter;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final File file = new File("src/main/resources/developers.json");

    public JavaIODeveloperRepositoryImpl() {

        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            List<Developer> list = getAll();
            counter = list.size() != 0 ? list.get(list.size()-1).getId() : 0;
        }

    }

    @Override
    public Developer getById(Integer id) {
        return getAll().stream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    @Override
    public Developer add(Developer developer) {

        developer.setId(++counter);

        List<Developer> developerList = getAll();

        developerList.add(developer);

        rewriteFile(developerList);

        return developer;

    }

    @Override
    public Developer update(Developer dev) {

        List<Developer> list = getAll();

        Developer temp = list.stream().filter(n -> n.getId() == dev.getId()).findAny().orElse(null);

        list.set(list.indexOf(temp), dev);

        rewriteFile(list);

        return null;

    }

    @Override
    public void removeById(Integer id) {

        List<Developer> list = getAll();

        Developer temp = list.stream().filter(n -> n.getId() == id).findAny().orElse(null);

        list.remove(temp);

        rewriteFile(list);

    }

    @Override
    public List<Developer> getAll() {

        Optional<List<Developer>> opt = Optional.empty();
        Type listDeveloperType = new TypeToken<ArrayList<Developer>>(){}.getType();

        try (Reader reader = Files.newBufferedReader(file.toPath())) {

            opt = Optional.ofNullable(gson.fromJson(reader, listDeveloperType));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return opt.orElse(new ArrayList<>());

    }

    private void rewriteFile(List<Developer> list) {

        try (Writer writer = Files.newBufferedWriter(file.toPath())) {

            gson.toJson(list, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
