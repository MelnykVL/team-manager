package com.melnykvl.teammanager;

import com.melnykvl.teammanager.model.Team;
import com.melnykvl.teammanager.model.TeamStatus;
import com.melnykvl.teammanager.repository.JavaIOTeamRepositoryImpl;
import com.melnykvl.teammanager.repository.TeamRepository;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {


        //Team team = new Team("Team-3", TeamStatus.DELETED, null);
        TeamRepository teamRepository = new JavaIOTeamRepositoryImpl();
        System.out.println(teamRepository.getAll());

        Team team = teamRepository.get(5);
//        team.setName("Some name");
//        team.setTeamStatus(TeamStatus.ACTIVE);
//        teamRepository.update(team);
//        for(int i = 0; i < 10; i++){
//            teamRepository.add(new Team("Team-" + (i+1), TeamStatus.DELETED, null));
//        }
        teamRepository.remove(team);

        System.out.println(teamRepository.getAll());


    }
}
