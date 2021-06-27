package com.melnykvl.teammanager.model;

public class Skill {

    private static int counter = 0;
    private Integer id;
    private String name;

    public Skill(String name) {
        this.id = ++counter;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
