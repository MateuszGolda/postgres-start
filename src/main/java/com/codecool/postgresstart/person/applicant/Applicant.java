package com.codecool.postgresstart.person.applicant;

import com.codecool.postgresstart.person.Person;

public class Applicant extends Person {
    private int applicationCode;

    int getApplicationCode() {
        return applicationCode;
    }

    void setApplicationCode(int applicationCode) {
        this.applicationCode = applicationCode;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", firstName='" + firstName + "'" +
                ", lastName='" + lastName + "'" +
                ", phoneNumber='" + phoneNumber + "'" +
                ", email='" + email + "'" +
                ", applicationCode='" + applicationCode + "'" +
                '}';
    }
}
