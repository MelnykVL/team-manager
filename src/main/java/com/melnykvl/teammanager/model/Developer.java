package com.melnykvl.teammanager.model;

import java.util.ArrayList;
import java.util.List;

public class Developer {

    private Integer id;
    private String firstName;
    private String lastName;
    private Team team;
    private List<Skill> skills;

    public Developer() {
        this.skills = new ArrayList<>();
    }

    public Developer(String firstName, String lastName, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        skills = new ArrayList<>();
    }

    public Developer(String firstName, String lastName, Team team, List<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.skills = skills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill model){
        this.skills.add(model);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                '}';
    }
}
