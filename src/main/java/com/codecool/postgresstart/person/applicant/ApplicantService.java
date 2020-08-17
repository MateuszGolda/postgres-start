package com.codecool.postgresstart.person.applicant;

import java.util.List;
import java.util.Optional;

public class ApplicantService {
    private final ApplicantDao applicantDAO;

    public ApplicantService(ApplicantDao applicantDAO) {
        this.applicantDAO = applicantDAO;
    }

    List<Applicant> getAll() {
        // some business logic
        // TODO
        return applicantDAO.getAll();
    }

    Optional<Applicant> getById(int id) {
        // some business logic
        // TODO
        return applicantDAO.getById(id);
    }

    List<Applicant> getByFirstName(String firstName) {
        // some business logic
        // TODO
        return applicantDAO.getByFirstName(firstName);
    }

    boolean insert(String firstName, String lastName, String phoneNumber, String email, int applicationCode) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPhoneNumber(phoneNumber);
        applicant.setEmail(email);
        applicant.setApplicationCode(applicationCode);
        return applicantDAO.insert(applicant);
    }

    boolean updatePhone(String firstName, String lastName, String newPhoneNumber) {
        var applicant = applicantDAO
                .getByBothNames(firstName, lastName)
                .get(0);
        applicant.setPhoneNumber(newPhoneNumber);
        return applicantDAO.update(applicant);
    }

    boolean deleteAt(String domain) {
        boolean deleted = false;
        var applicants = applicantDAO
                .getByEmailAt(domain);
        for (Applicant applicant : applicants) {
            deleted = applicantDAO.delete(applicant) || deleted;
        }
        return deleted;
    }

    List<Applicant> getByEmailAt(String emailDomain) {
        return applicantDAO.getByEmailAt(emailDomain);
    }

    List<Applicant> getByApplication(int application) {
        return applicantDAO.getByApplication(application);
    }

    List<Applicant> getByBothNames(String firstName, String lastName) {
        return applicantDAO.getByBothNames(firstName, lastName);
    }
}
