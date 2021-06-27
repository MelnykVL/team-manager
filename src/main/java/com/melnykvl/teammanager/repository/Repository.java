package com.melnykvl.teammanager.repository;

import com.google.gson.Gson;

import java.util.List;

public interface Repository<T, ID> {

    Gson gson = new Gson();

    T get(ID id);
    void add(T t);
    void update(T t);
    void remove(T t);

    List<T> getAll();

}
