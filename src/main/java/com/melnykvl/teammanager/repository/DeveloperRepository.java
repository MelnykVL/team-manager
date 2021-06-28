package com.melnykvl.teammanager.repository;

import com.melnykvl.teammanager.model.Developer;

import java.util.List;

public interface DeveloperRepository extends Repository<Developer, Integer> {

    List<Developer> getAll();

}
