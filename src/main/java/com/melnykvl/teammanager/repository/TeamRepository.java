package com.melnykvl.teammanager.repository;


import com.melnykvl.teammanager.model.Team;

import java.util.List;

public interface TeamRepository extends Repository<Team, Integer> {

    List<Team> getAll();

}
