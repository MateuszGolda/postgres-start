package com.codecool.postgresstart.person.mentor;

import com.codecool.postgresstart.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MentorDao implements Dao<Mentor> {
    private final Connection c;

    public MentorDao(Connection connection) {
        c = connection;
    }

    @Override
    public List<Mentor> getAll() {
        List<Mentor> mentors = new ArrayList<>();

        try (PreparedStatement stmt = c.prepareStatement("SELECT * FROM mentors;");
             ResultSet results = stmt.executeQuery()
        ) {
            while (results.next()) {
                Mentor mentor = createMentor(results);
                mentors.add(mentor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }

    @Override
    public Optional<Mentor> getById(int id) {
        Mentor mentor = null;
        try (PreparedStatement stmt = c.prepareStatement("SELECT * FROM mentors WHERE ? = ?;")
        ) {
            stmt.setString(1, "id");
            stmt.setInt(2, id);
            ResultSet results = stmt.executeQuery();
            mentor = createMentor(results);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(mentor);
    }

    @Override
    public List<Mentor> getByFirstName(String firstName) {
        return get("first_name", firstName);
    }

    @Override
    public List<Mentor> getByLastName(String lastName) {
        return get("last_name", lastName);
    }

    @Override
    public List<Mentor> getByPhoneNumber(String phoneNumber) {
        return get("phone_number", phoneNumber);
    }

    @Override
    public List<Mentor> getByEmail(String email) {
        return get("email", email);
    }

    public List<Mentor> getByCity(String city) {
        return get("city", city);
    }

    private List<Mentor> get(String column, Object value) {
        List<Mentor> mentors = new ArrayList<>();
        try (PreparedStatement stmt = c.prepareStatement("SELECT * FROM mentors WHERE " + column + " = ?;")
        ) {
            if (value instanceof String) {
                stmt.setString(1, (String) value);
            } else if (value instanceof Integer) {
                stmt.setInt(1, (Integer) value);
            }
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                Mentor mentor = createMentor(results);
                mentors.add(mentor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }

    private Mentor createMentor(ResultSet results) throws SQLException {
        Mentor mentor = new Mentor();
        mentor.setId(results.getInt("id"));
        mentor.setFirstName(results.getString("first_name"));
        mentor.setLastName(results.getString("last_name"));
        mentor.setNickName(results.getString("nick_name"));
        mentor.setPhoneNumber(results.getString("phone_number"));
        mentor.setEmail(results.getString("email"));
        mentor.setCity(results.getString("city"));
        mentor.setFavouriteNumber(results.getInt("favourite_number"));
        return mentor;
    }

    @Override
    public boolean insert(Mentor mentor) {
        try {
            PreparedStatement stmt = c.prepareStatement(
                    "INSERT INTO mentors (first_name, last_name, nick_name, phone_number, email, city, favourite_number)" +
                            " VALUES (?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, mentor.getFirstName());
            stmt.setString(2, mentor.getLastName());
            stmt.setString(3, mentor.getNickName());
            stmt.setString(4, mentor.getPhoneNumber());
            stmt.setString(5, mentor.getEmail());
            stmt.setString(6, mentor.getCity());
            stmt.setInt(7, mentor.getFavouriteNumber());
            stmt.executeUpdate();
            // TODO it might be better to return void here
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Mentor mentor) {
        try {
            PreparedStatement stmt = c.prepareStatement(
                    "UPDATE mentors" +
                            " SET first_name = ?," +
                            " last_name = ?," +
                            " nick_name = ?," +
                            " phone_number = ?," +
                            " email = ?," +
                            " city = ?," +
                            " favourite_number = ?" +
                            " WHERE id = ?;");
            stmt.setString(1, mentor.getFirstName());
            stmt.setString(2, mentor.getLastName());
            stmt.setString(3, mentor.getNickName());
            stmt.setString(4, mentor.getPhoneNumber());
            stmt.setString(5, mentor.getEmail());
            stmt.setString(6, mentor.getCity());
            stmt.setInt(7, mentor.getFavouriteNumber());
            stmt.setInt(8, mentor.getId());
            stmt.executeUpdate();
            // TODO it might be better to return void here
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Mentor mentor) {
        try {
            PreparedStatement stmt = c.prepareStatement("DELETE" +
                    " FROM mentors" +
                    " WHERE id = ?;");
            stmt.setInt(1, mentor.getId());
            stmt.executeUpdate();
            // TODO it might be better to return void here
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
