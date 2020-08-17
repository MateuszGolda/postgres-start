package com.codecool.postgresstart;

import com.codecool.postgresstart.person.applicant.ApplicantController;
import com.codecool.postgresstart.person.applicant.ApplicantDao;
import com.codecool.postgresstart.person.applicant.ApplicantLogger;
import com.codecool.postgresstart.person.applicant.ApplicantService;
import com.codecool.postgresstart.person.mentor.MentorController;
import com.codecool.postgresstart.person.mentor.MentorDao;
import com.codecool.postgresstart.person.mentor.MentorLogger;
import com.codecool.postgresstart.person.mentor.MentorService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = new PostgreSqlJDBC()
                .getConnection("jdbc:postgresql://localhost:5432/newuser", "newuser", "newuser");

        MentorController mc = new MentorController(
                new MentorService(new MentorDao(connection)), new MentorLogger());

        ApplicantController ac = new ApplicantController(
                new ApplicantService(new ApplicantDao(connection)), new ApplicantLogger());
        mainMenu(mc, ac);
    }

    public static void mainMenu(MentorController mc, ApplicantController ac) {
        var sc = new Scanner(System.in);

        printMenu();

        switch (sc.nextLine()) {
            case "0" -> mc.displayAllMentors();
            case "1" -> mc.displayMentorsNickNamesFrom("Miskolc");
            case "2" -> ac.displayApplicantByName("Carol");
            case "3" -> ac.displayApplicantWithEmailAt("%adipiscingenimmi.edu");
            case "4" -> {
                ac.addApplicant("Markus", "Schaffarzyk", "003620/725-2666", "djnovus@groovecoverage.com", 54823);
                ac.displayApplicantByApplication(54823);
            }
            case "5" -> {ac.updateApplicantPhone("Jemima", "Foreman", "003670/223-7459");
                ac.displayApplicantByBothNames("Jemima", "Foreman");}
            case "6" -> ac.deleteApplicantsAt("%mauriseu.net");
            case "7" -> {}
            case "8" -> {}
            case "9" -> {}
            case "a" -> {}
            case "b" -> {}
        }
    }

    private static void printMenu() {
        System.out.println(
                "(0) Display name, and surname of all mentors\n" +
                "(1) Display nicknames of Miskolc mentors'\n" +
                "(2) Display full name, and phone of applicant called Carol\n" +
                "(3) Display full name, and phone of applicant with email at adipiscingenimmi.edu\n" +
                "(4) Add, and display new applicant\n" +
                "(5) Update applicant's phone number\n" +
                "(6) Delete applicants at mauriseu.net\n" +
                "(7) Insert mentor\n" +
                "(8) Update mentor\n" +
                "(9) Insert applicant\n" +
                "(a) Update applicant\n" +
                "(b) Search");
    }
}
