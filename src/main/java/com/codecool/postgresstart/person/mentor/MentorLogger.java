package com.codecool.postgresstart.person.mentor;

import com.codecool.postgresstart.person.mentor.Mentor;

import java.util.List;

public class MentorLogger {
    private final int maxLength = 15;

    public void log(List<Mentor> mentors) {
        String firstColumn = "First name";
        String secondColumn = "Last name";
        System.out.print(firstColumn + " ".repeat(maxLength - firstColumn.length()) + "\t");
        System.out.println(secondColumn);
        for (Mentor mentor : mentors) {
            System.out.print(mentor.getFirstName());
            System.out.print(" ".repeat(maxLength - mentor.getFirstName().length()) + "\t");
            System.out.println(mentor.getLastName());
        }
    }

    public void logNickNames(List<Mentor> mentors) {
        String firstColumn = "First name";
        String secondColumn = "Last name";
        String thirdColumn = "Nickname";
        System.out.print(firstColumn + " ".repeat(maxLength - firstColumn.length()) + "\t");
        System.out.print(secondColumn + " ".repeat(maxLength - secondColumn.length()) + "\t");
        System.out.println(thirdColumn);
        for (Mentor mentor : mentors) {
            System.out.print(mentor.getFirstName());
            System.out.print(" ".repeat(maxLength - mentor.getFirstName().length()) + "\t");
            System.out.print(mentor.getLastName());
            System.out.print(" ".repeat(maxLength - mentor.getLastName().length()) + "\t");
            System.out.println(mentor.getNickName());
        }
    }
}
