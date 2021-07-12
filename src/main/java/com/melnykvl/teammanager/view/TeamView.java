package com.melnykvl.teammanager.view;

import com.melnykvl.teammanager.model.Team;
import com.melnykvl.teammanager.repository.JavaIOTeamRepositoryImpl;
import com.melnykvl.teammanager.repository.TeamRepository;

public class TeamView {

    private TeamRepository tr = new JavaIOTeamRepositoryImpl();

    public void show() {
        System.out.println("Список всех комманд");
        System.out.println(tr.getAll());
    }

    public void show(Integer id) {
        System.out.println("Команда с идентификатором " + id);
        System.out.println(tr.getById(id));
    }

    public void show(Team team) {
        System.out.println(team);
    }

}
