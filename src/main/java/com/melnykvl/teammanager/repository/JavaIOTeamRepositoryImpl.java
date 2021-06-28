package com.melnykvl.teammanager.repository;

import com.melnykvl.teammanager.model.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOTeamRepositoryImpl implements TeamRepository {

    private final File file = new File("src/main/resources/teams.txt");
    private List<Team> teamList = new ArrayList<>();

    public JavaIOTeamRepositoryImpl() {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            fillList();
            Team.counter = teamList.size() != 0 ? teamList.get(teamList.size()-1).getId() : 0;

        }

    }

    @Override
    public Team get(Integer id) {
        return teamList.stream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    @Override
    public void add(Team model) {

        teamList.add(model);
        write(model);

    }

    @Override
    public void update(Team model) {
        teamList.set(teamList.indexOf(model), model);
        rewrite(teamList);
    }

    @Override
    public void remove(Team model) {
        if (teamList.remove(model)) rewrite(teamList);
    }

    @Override
    public List<Team> getAll() {
        return teamList;
    }

    private void fillList() {

        try (InputStream is = new FileInputStream(file);
             Reader r = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(r)) {

            //Type teamListType = new TypeToken<ArrayList<Team>>(){}.getType();

            Team team = null;
            String line = null;

            while((line = br.readLine()) != null){

                team = gson.fromJson(line, Team.class);
                teamList.add(team);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void write(Team model){

        try (Writer w = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(w)){

            bw.append(gson.toJson(model) + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void rewrite(List<Team> list){

        file.delete();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Team model : list){
            write(model);
        }

    }

}
