package com.melnykvl.teammanager.controller;

import com.melnykvl.teammanager.model.Team;
import com.melnykvl.teammanager.model.TeamStatus;
import com.melnykvl.teammanager.repository.*;
import com.melnykvl.teammanager.repository.implementation.JavaIODeveloperRepositoryImpl;
import com.melnykvl.teammanager.repository.implementation.JavaIOTeamRepositoryImpl;
import com.melnykvl.teammanager.view.DeveloperView;
import com.melnykvl.teammanager.view.TeamView;

import java.util.Scanner;

public class TeamController {

    private TeamView tv = new TeamView();
    private DeveloperView dv = new DeveloperView();
    private TeamRepository tr = new JavaIOTeamRepositoryImpl();
    private DeveloperRepository dr = new JavaIODeveloperRepositoryImpl();

    public void execute() {

        Scanner scan = new Scanner(System.in);
        String command = "";

        tv.showListOfCommands();

        System.out.print("Введите команду:");
        command = scan.nextLine();

        menu(command);

    }

    private void menu(String command) {

        if (command.equalsIgnoreCase("show")) {
            tv.show();
            execute();
        } else if (command.equalsIgnoreCase("get")) {
            get();
            execute();
        } else if (command.equalsIgnoreCase("create")) {
            addDev();
            execute();
        } else if (command.equalsIgnoreCase("remove")) {
            removeObj();
            execute();
        } else if (command.equalsIgnoreCase("return")) {
            return;
        } else {
            System.out.println("Команда не найдена!");
            execute();
        }

    }

    private void removeObj() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        tr.removeById(id);
    }

    private void removeObj(Team team) {
        tr.removeById(team.getId());
    }

    private void addDev() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Имя: ");
        String name = scan.nextLine();
        TeamStatus status;

        status = inputStatus();
        if (status == null) return;

        tr.add(new Team(name, status));

    }

    private TeamStatus inputStatus() {

        Scanner scan = new Scanner(System.in);
        String str = "";
        TeamStatus status;

        System.out.print("Введите новый статус (1 - active, 2 - deleted): ");
        str = scan.nextLine();

        if (str.equalsIgnoreCase("1"))
            status = TeamStatus.ACTIVE;
        else if (str.equalsIgnoreCase("2"))
            status = TeamStatus.DELETED;
        else {
            System.out.println("Введеного статуса не существует");
            return null;
        }
        return status;

    }

    private void get() {

        Scanner scan = new Scanner(System.in);

        Team team;
        String command = "";
        int id;

        System.out.print("Введите id: ");
        id = scan.nextInt();
        team = tr.getById(id);

        tv.show(id);

        if (team == null) return;

        tv.showObjectActions();

        System.out.print("Введите действия: ");
        scan = new Scanner(System.in);
        command = scan.nextLine();

        menuForObj(team, command);

    }

    private void menuForObj(Team team, String command) {
        if (command.equalsIgnoreCase("add dev"))
            addDev(team);
        else if (command.equalsIgnoreCase("delete dev"))
            deleteDev(team);
        else if (command.equalsIgnoreCase("change name"))
            changeName(team);
        else if (command.equalsIgnoreCase("change status"))
            changeStatus(team);
        else if (command.equalsIgnoreCase("remove"))
            removeObj(team);
        else
            System.out.println("Команда не найдена!");
    }

    private void changeStatus(Team team) {

        team.setTeamStatus(inputStatus());

        tr.update(team);

    }

    private void changeName(Team team) {

        Scanner scan = new Scanner(System.in);
        String name = "";

        System.out.print("Введите новое название для команды: ");
        name = scan.nextLine();

        team.setName(name);

        tr.update(team);

    }

    private void addDev(Team team) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите id добавляемого разработчика из списка ниже".toUpperCase());

        dv.show();

        System.out.print("Введите id: ");
        int id = scan.nextInt();

        team.addDeveloper(dr.getById(id));

        tr.update(team);

    }

    private void deleteDev(Team team) {

        if (team.getDevelopers().size() != 0) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Выберите id удаляемого разработчика из списка ниже".toUpperCase());

            System.out.println(team.getDevelopers());

            System.out.print("Введите id: ");
            int id = scan.nextInt();

            team.removeDeveloper(id);

            tr.update(team);

        } else {
            System.out.println("Нечего удалять!");
        }

    }

}
