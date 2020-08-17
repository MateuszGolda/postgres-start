package com.codecool.postgresstart.person.applicant;

public class ApplicantController {
    private final ApplicantLogger applicantLogger;
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService, ApplicantLogger applicantLogger) {
        this.applicantService = applicantService;
        this.applicantLogger = applicantLogger;
    }

    public void displayAllApplicants() {
        applicantLogger.log(
                applicantService.getAll());
    }

    public void displayApplicantByName(String firstName) {
        applicantLogger.log(
                applicantService.getByFirstName(firstName));
    }

    public void displayApplicantByBothNames(String firstName, String lastName) {
        applicantLogger.log(
                applicantService.getByBothNames(firstName, lastName));
    }

    public void displayApplicantWithEmailAt(String emailDomain) {
        applicantLogger.log(
                applicantService.getByEmailAt(emailDomain));
    }

    public void addApplicant(String firstName, String lastName, String phoneNumber, String email, int application) {
        applicantLogger.logInserted(
                applicantService.insert(firstName, lastName, phoneNumber, email, application));
    }

    public void updateApplicantPhone(String firstName, String lastName, String newPhoneNumber) {
        applicantService.updatePhone(firstName, lastName, newPhoneNumber);
    }

    public void deleteApplicantsAt(String domain) {
        applicantService.deleteAt(domain);
    }

    public void displayApplicantByApplication(int application) {
        applicantLogger.log(
                applicantService.getByApplication(application));
    }
}
