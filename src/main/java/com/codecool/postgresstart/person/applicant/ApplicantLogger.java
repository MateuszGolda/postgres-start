package com.codecool.postgresstart.person.applicant;

import java.util.List;

public class ApplicantLogger {
    private final int maxLength = 15;

    public void log(List<Applicant> applicant) {
        String firstColumn = "First name";
        String secondColumn = "Last name";
        System.out.print(firstColumn + " ".repeat(maxLength - firstColumn.length()) + "\t");
        System.out.println(secondColumn);
        for (Applicant mentor : applicant) {
            System.out.print(mentor.getFirstName());
            System.out.print(" ".repeat(maxLength - mentor.getFirstName().length()) + "\t");
            System.out.println(mentor.getLastName());
        }
    }

    void logInserted(boolean inserted) {
        System.out.println(inserted ? "Inserted successfully" : "Insertion failed");
    }
}
