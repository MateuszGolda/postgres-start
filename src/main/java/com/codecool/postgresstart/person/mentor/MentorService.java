package com.codecool.postgresstart.person.mentor;

import java.util.List;
import java.util.Optional;

public class MentorService {
    private final MentorDao mentorDAO;

    public MentorService(MentorDao mentorDAO) {
        this.mentorDAO = mentorDAO;
    }

    List<Mentor> getAll() {
        // some business logic
        // TODO
        return mentorDAO.getAll();
    }

    Optional<Mentor> getById(int id) {
        // some business logic
        // TODO
        return mentorDAO.getById(id);
    }

    List<Mentor> getByCity(String city) {
        // some business logic
        // TODO
        return mentorDAO.getByCity(city);
    }

    boolean insert(Mentor mentor) {
        // some business logic
        // TODO
        return mentorDAO.insert(mentor);
    }

    boolean update(Mentor mentor) {
        // some business logic
        // TODO
        return mentorDAO.update(mentor);
    }

    boolean delete(Mentor mentor) {
        // some business logic
        // TODO
        return mentorDAO.delete(mentor);
    }
}
