package com.melnykvl.teammanager;

import com.melnykvl.teammanager.model.Team;
import com.melnykvl.teammanager.model.TeamStatus;
import com.melnykvl.teammanager.repository.TeamRepository;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {


        Team team = new Team(2, "DOGS", TeamStatus.DELETED, null);
        TeamRepository teamRepository = new TeamRepository();
        teamRepository.add(team);

    }
}
