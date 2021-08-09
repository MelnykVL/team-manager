package com.melnykvl.teammanager.controller;

import com.melnykvl.teammanager.model.Skill;
import com.melnykvl.teammanager.repository.implementation.JavaIOSkillRepositoryImpl;
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

        menu(command);

    }

    private void menu(String command) {
        if (command.equalsIgnoreCase("show")) {
            sv.show();
            execute();
        } else if (command.equalsIgnoreCase("get")) {
            get();
            execute();
        } else if (command.equalsIgnoreCase("create")) {
            addObject();
            execute();
        } else if (command.equalsIgnoreCase("remove")) {
            removeObj();
            execute();
        } else if (command.equalsIgnoreCase("return")) {
            return;
        }else {
            System.out.println("Команда не найдена!");
            execute();
        }
    }

    private void removeObj() {

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        sr.removeById(id);
    }

    private void removeObj(Skill skill) {
        sr.removeById(skill.getId());
    }

    private void addObject() {

        System.out.print("Имя: ");
        String name = scan.nextLine();

        sr.add(new Skill(name));

    }

    private void get() {
        Scanner scan = new Scanner(System.in);

        Skill skill;
        String command = "";
        int id;


        System.out.print("Введите id: ");
        id = scan.nextInt();
        skill = sr.getById(id);

        sv.show(id);

        if (skill == null) return;

        sv.showObjectActions();

        System.out.print("Введите действия: ");
        scan = new Scanner(System.in);
        command = scan.nextLine();

        menuForObj(skill, command);

    }

    private void menuForObj(Skill skill, String command) {
        if (command.equalsIgnoreCase("change name"))
            changeName(skill);
        else if (command.equalsIgnoreCase("remove"))
            removeObj(skill);
        else
            System.out.println("Команда не найдена!");
    }

    private void changeName(Skill skill) {

        Scanner scan = new Scanner(System.in);
        String name = "";

        System.out.print("Введите новое имя навыка: ");
        name = scan.nextLine();

        skill.setName(name);

        sr.update(skill);

    }

}
