package com.melnykvl.teammanager.model;

import com.melnykvl.teammanager.repository.TeamRepository;

import java.util.List;

public class Team {


    private Integer id;
    private String name;
    private TeamStatus teamStatus;
    private List<Developer> developers;

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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamStatus=" + teamStatus +
                ", developers=" + developers +
                '}';
    }
}
