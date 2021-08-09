package com.melnykvl.teammanager.view;

import com.melnykvl.teammanager.model.Developer;
import com.melnykvl.teammanager.repository.DeveloperRepository;
import com.melnykvl.teammanager.repository.implementation.JavaIODeveloperRepositoryImpl;

import java.util.List;

public class DeveloperView {

    private DeveloperRepository dr = new JavaIODeveloperRepositoryImpl();

    public void showListOfCommands() {
        System.out.println("\n|----Робота со списком разработчиков----|".toUpperCase());
        System.out.println("\t1. show (показать список разработчиков)");
        System.out.println("\t2. get (перейти к разработчику по идентификатору)");
        System.out.println("\t3. create (создать разработчика)");
        System.out.println("\t4. remove (удалить разработчика по идентефикатору)");
        System.out.println("\t5. return (вернуться в главное меню)");
    }

    public void show() {
        System.out.println("Список всех разработчиков");
        List<Developer> list = dr.getAll();
        for (Developer dev : list)
            System.out.println(dev);
    }

    public void show(Integer id) {

        Developer dev = dr.getById(id);

        if (dev != null) {
            System.out.println("Разработчик с идентификатором " + id);
            System.out.println(dev);
        } else {
            System.out.println("Разработчика с таким id не существует");
        }

    }

    public void showObjectActions() {
        System.out.println("Действия над объектом:");
        System.out.println("\tadd skill (добавить навык)");
        System.out.println("\tdelete skill (удалить навык)");
        System.out.println("\tchange fn (изменить имя)");
        System.out.println("\tchange ln (изменить фамилию)");
        System.out.println("\tremove (удалить объект)");
    }

}
