package com.codecool.postgresstart;

public class Queries {
    String selectAllMentors = "SELECT first_name, last_name"
            + " FROM mentors;";

    String selectMiscolcMentorsNickNames = "SELECT nick_name"
            + " FROM mentors"
            + " WHERE city = 'Miskolc';";

    String selectApplicantCarol = "SELECT CONCAT(first_name, ' ', last_name) AS full_name, phone_number"
            + " FROM applicants"
            + " WHERE first_name = 'Carol';";

    // todo
    String selectApplicantAtAdipiscingenimmi = "SELECT CONCAT(first_name, ' ', last_name) AS full_name, phone_number"
            + " FROM applicants"
            + " WHERE email LIKE '%@adipiscingenimmi.edu';";

    String insertMarkus = "INSERT INTO applicants(first_name, last_name, phone_number, email, application)"
            + " VALUES ('Markus', 'Schaffarzyk', '003620/725-2666', 'djnovus@groovecoverage.com', 54823);";

    String selectMarkus = "SELECT *"
            + " FROM applicants"
            + " WHERE application = 54823;";

    String updatePhone = "UPDATE applicants"
            + " SET phone_number = '003670/223-7459'"
            + " WHERE first_name = 'Jemima'"
            + " AND last_name = 'Foreman';";

    String selectUpdatedPhone = "SELECT first_name, last_name, phone_number"
            + " FROM applicants"
            + " WHERE first_name = 'Jemima'"
            + " AND last_name = 'Foreman';";

    String deleteApplicantsAtMauriseu = "DELETE"
            + " FROM applicants"
            + " WHERE email LIKE '%mauriseu.net';";
}
