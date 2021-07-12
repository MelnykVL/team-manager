package com.melnykvl.teammanager;

import com.melnykvl.teammanager.model.Developer;
import com.melnykvl.teammanager.model.Skill;
import com.melnykvl.teammanager.model.Team;
import com.melnykvl.teammanager.model.TeamStatus;
import com.melnykvl.teammanager.repository.*;

public class Main {
    public static void main(String[] args) {


        TeamRepository tr = new JavaIOTeamRepositoryImpl();
        DeveloperRepository dr = new JavaIODeveloperRepositoryImpl();
        SkillRepository sr = new JavaIOSkillRepositoryImpl();

        System.out.println(tr.getAll());
        System.out.println(dr.getAll());
        System.out.println(sr.getAll());

        Team team = tr.getById(2);
        team.setDevelopers(dr.getAll());
        tr.update(team);

//        Developer dev = dr.getById(3);
//        dev.addSkill(sr.getById(1));
//        dev.addSkill(sr.getById(2));
//        dev.addSkill(sr.getById(3));
//        dev.addSkill(sr.getById(4));
//        dev.addSkill(sr.getById(5));
//        dr.update(dev);

//        for(int i = 0; i < 5; i++){
//            tr.add(new Team("Team-" + (i+1), TeamStatus.DELETED, null));
//            dr.add(new Developer("First name-" + (i+1), "Last name-" + (i+1), null));
//        }
//
//        sr.add(new Skill("Java 8"));
//        sr.add(new Skill("Hibernate"));
//        sr.add(new Skill("JUnit/Mockito"));
//        sr.add(new Skill("Spring Framework"));
//        sr.add(new Skill("PostgreSQL"));

    }
}
