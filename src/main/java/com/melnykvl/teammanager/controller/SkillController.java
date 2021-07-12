package com.melnykvl.teammanager.controller;

import com.melnykvl.teammanager.model.Skill;
import com.melnykvl.teammanager.repository.JavaIOSkillRepositoryImpl;
import com.melnykvl.teammanager.repository.SkillRepository;
import com.melnykvl.teammanager.view.SkillView;

import java.util.Scanner;

public class SkillController {

    private SkillView sv = new SkillView();
    private SkillRepository sr = new JavaIOSkillRepositoryImpl();
    Scanner scan = new Scanner(System.in);

    public void execute() {

        sv.showListOfCommands();

        System.out.print("Введите команду: ");
        String command = scan.nextLine();

        if (command.equalsIgnoreCase("show"))
            sv.show();
        else if (command.equalsIgnoreCase("get"))
            get();
        else if (command.equalsIgnoreCase("create"))
            addObject();
        else if (command.equalsIgnoreCase("delete"))
            removeObject();
        else
            System.out.println("Команда не найдена!");

    }

    private void removeObject() {

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        sr.removeById(id);
    }

    private void addObject() {

        System.out.print("Имя: ");
        String name = scan.nextLine();

        sr.add(new Skill(name));

    }

    private void get() {

        System.out.print("Введите id: ");
        int id = scan.nextInt();
        sv.show(id);

    }

}
