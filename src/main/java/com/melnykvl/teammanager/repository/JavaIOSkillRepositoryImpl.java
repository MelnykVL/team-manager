package com.melnykvl.teammanager.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.melnykvl.teammanager.model.Skill;
import com.melnykvl.teammanager.model.Team;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private static int counter;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
    public Skill getById(Integer id) {
        return getAll().stream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    @Override
    public Skill add(Skill skill) {

        skill.setId(++counter);

        List<Skill> list = getAll();

        list.add(skill);

        rewriteFile(list);

        return skill;
    }

    @Override
    public Skill update(Skill skill) {

        List<Skill> list = getAll();

        Skill temp = list.stream().filter(n -> n.getId() == skill.getId()).findAny().get();

        list.set(list.indexOf(temp), skill);

        rewriteFile(list);

        return skill;

    }

    @Override
    public void removeById(Integer id) {

        List<Skill> list = getAll();

        Skill temp = list.stream().filter(n -> n.getId() == id).findAny().orElse(null);

        list.remove(temp);

        rewriteFile(list);

    }

    @Override
    public List<Skill> getAll() {

        Optional<List<Skill>> opt = Optional.empty();
        Type listTeamType = new TypeToken<ArrayList<Skill>>(){}.getType();

        try (Reader reader = Files.newBufferedReader(file.toPath())) {

            opt = Optional.ofNullable(gson.fromJson(reader, listTeamType));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return opt.orElse(new ArrayList<>());

    }

    private void rewriteFile(List<Skill> list) {

        try (Writer writer = Files.newBufferedWriter(file.toPath())) {

            gson.toJson(list, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
