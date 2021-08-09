package com.melnykvl.teammanager;

import com.melnykvl.teammanager.controller.DeveloperController;
import com.melnykvl.teammanager.controller.SkillController;
import com.melnykvl.teammanager.controller.TeamController;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TeamController tc = new TeamController();
        DeveloperController dc = new DeveloperController();
        SkillController sc = new SkillController();

        String command = "";
        Scanner scan = new Scanner(System.in);

        checkFile();

        while (true) {

            System.out.println("\n1 - перейти к командам разработчиков");
            System.out.println("2 - перейти к разработчикам");
            System.out.println("3 - перейти к умениям");
            System.out.println("exit - завершение программы");

            System.out.print("Введите команду: ");
            command = scan.nextLine();

            if (command.equals("1"))
                tc.execute();
            else if (command.equals("2"))
                dc.execute();
            else if (command.equals("3"))
                sc.execute();
            else if (command.equalsIgnoreCase("exit"))
                return;
            else
                System.out.println("Команда не найдена");

        }

    }

    private static void checkFile() {

        final File skillsFile = new File("src/main/resources/skills.json");
        final File developersFile = new File("src/main/resources/developers.json");
        final File teamsFile = new File("src/main/resources/teams.json");

        if (!skillsFile.exists()) {
            try {
                skillsFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!developersFile.exists()) {
            try {
                developersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!teamsFile.exists()) {
            try {
                teamsFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
