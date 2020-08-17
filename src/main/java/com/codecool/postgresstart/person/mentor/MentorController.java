package com.codecool.postgresstart.person.mentor;

public class MentorController {
    private final MentorLogger mentorLogger;
    private final MentorService mentorService;

    public MentorController(MentorService mentorService, MentorLogger mentorLogger) {
        this.mentorService = mentorService;
        this.mentorLogger = mentorLogger;
    }

    public void displayAllMentors() {
        mentorLogger.log(
                mentorService.getAll());
    }

    public void displayMentorsNickNamesFrom(String city) {
        mentorLogger.logNickNames(
                mentorService.getByCity(city));
    }

    public void insertMentor() {

    }

    public void updateMentor() {

    }
}
