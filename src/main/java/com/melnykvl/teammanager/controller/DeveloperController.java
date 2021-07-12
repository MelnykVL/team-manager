package com.melnykvl.teammanager.controller;

import com.melnykvl.teammanager.model.Developer;
import com.melnykvl.teammanager.model.Skill;
import com.melnykvl.teammanager.repository.DeveloperRepository;
import com.melnykvl.teammanager.repository.JavaIODeveloperRepositoryImpl;
import com.melnykvl.teammanager.repository.JavaIOSkillRepositoryImpl;
import com.melnykvl.teammanager.repository.SkillRepository;
import com.melnykvl.teammanager.view.DeveloperView;
import com.melnykvl.teammanager.view.SkillView;

import java.util.Scanner;

public class DeveloperController {

    private DeveloperView dv = new DeveloperView();
    private SkillView sv = new SkillView();
    private DeveloperRepository dr = new JavaIODeveloperRepositoryImpl();
    private SkillRepository sr = new JavaIOSkillRepositoryImpl();


    public void execute() {

        Scanner scan = new Scanner(System.in);
        String command = "";

        dv.showListOfCommands();

        System.out.print("Введите команду: ");
        command = scan.nextLine();

        if (command.equalsIgnoreCase("show")) {
            dv.show();
            execute();
        } else if (command.equalsIgnoreCase("get")) {
            get();
            execute();
        } else if (command.equalsIgnoreCase("create")) {
            addDev();
            execute();
        } else if (command.equalsIgnoreCase("delete")) {
            deleteObj();
            execute();
        } else if (command.equalsIgnoreCase("return")) {
            return;
        } else {
            System.out.println("Команда не найдена!");
            execute();
        }

    }

    private void deleteObj() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        dr.removeById(id);
    }

    private void deleteObj(Developer dev) {
        dr.removeById(dev.getId());
    }

    private void addDev() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Имя: ");
        String firstName = scan.nextLine();
        System.out.print("Фамилия: ");
        String lastName = scan.nextLine();

        dr.add(new Developer(firstName, lastName));

    }

    private void get() {

        Scanner scan = new Scanner(System.in);

        Developer dev;
        String command = "";
        int id;

        System.out.print("Введите id: ");
        id = scan.nextInt();
        dev = dr.getById(id);

        dv.show(id);

        if (dev == null) return;

        dv.showObjectActions();

        System.out.print("Введите действия: ");
        scan = new Scanner(System.in);
        command = scan.nextLine();

        if (command.equalsIgnoreCase("add skill"))
            addSkill(dev);
        else if (command.equalsIgnoreCase("remove skill"))
            removeSkill(dev);
        else if (command.equalsIgnoreCase("delete"))
            deleteObj(dev);
        else
            System.out.println("Команда не найдена!");

    }

    private void addSkill(Developer dev) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите id добавляемого навыка из списка ниже".toUpperCase());

        sv.show();

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        dev.addSkill(sr.getById(id));

        dr.update(dev);

    }

    private void removeSkill(Developer dev) {

        if (dev.getSkills().size() != 0) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Выберите id удаляемого навыка из списка ниже".toUpperCase());

            System.out.println(dev.getSkills());

            System.out.print("Введите id: ");
            int id = scan.nextInt();

            dev.removeSkill(id);

            dr.update(dev);

        } else {
            System.out.println("Нечего удалять!");
        }

    }

}
