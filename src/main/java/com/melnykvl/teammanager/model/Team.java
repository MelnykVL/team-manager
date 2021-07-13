package com.melnykvl.teammanager.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Integer id;
    private String name;
    private TeamStatus teamStatus;
    private List<Developer> developers;

    public Team() {
        this.developers = new ArrayList<>();
    }

    public Team(String name, TeamStatus teamStatus) {
        this.name = name;
        this.teamStatus = teamStatus;
        this.developers = new ArrayList<>();
    }

    public Team(String name, TeamStatus teamStatus, List<Developer> developers) {
        this.name = name;
        this.teamStatus = teamStatus;
        this.developers = developers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public void addDeveloper(Developer model){
        this.developers.add(model);
    }

    public void removeDeveloper(Integer id) {

        for (Developer d : developers)
            if (d.getId() == id)
                this.developers.remove(d);

    }

    @Override
    public String toString() {
        return "\nКоманда ID-" + id +
                ": Название = '" + name + '\'' +
                "; Статус = " + teamStatus +
                "; Члены команды:" + developers;
    }
}
