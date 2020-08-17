package com.codecool.postgresstart.person.applicant;

import com.codecool.postgresstart.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApplicantDao implements Dao<Applicant> {
    private final Connection c;

    public ApplicantDao(Connection connection) {
        c = connection;
    }

    @Override
    public List<Applicant> getAll() {
        List<Applicant> applicants = new ArrayList<>();

        try (PreparedStatement stmt = c.prepareStatement("SELECT * FROM applicants;");
             ResultSet results = stmt.executeQuery()
        ) {
            while (results.next()) {
                Applicant applicant = createApplicant(results);
                applicants.add(applicant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicants;
    }

    @Override
    public Optional<Applicant> getById(int id) {
        Applicant applicant = null;
        try (PreparedStatement stmt = c.prepareStatement("SELECT * FROM applicants WHERE ? = ?;")
        ) {
            stmt.setString(1, "id");
            stmt.setInt(2, id);
            ResultSet results = stmt.executeQuery();
            applicant = createApplicant(results);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(applicant);
    }

    @Override
    public List<Applicant> getByFirstName(String firstName) {
        String query = "SELECT * FROM applicants WHERE first_name = ?;";
        return get(query, firstName);
    }

    @Override
    public List<Applicant> getByLastName(String lastName) {
        String query = "SELECT * FROM applicants WHERE last_name = ?;";
        return get(query, lastName);
    }


    public List<Applicant> getByBothNames(String firstName, String lastName) {
        String query = "SELECT * FROM applicants WHERE first_name = ? AND last_name = ?;";
        return get(query, firstName);
    }

    @Override
    public List<Applicant> getByPhoneNumber(String phoneNumber) {
        String query = "SELECT * FROM applicants WHERE phone_number = ?;";
        return get(query, phoneNumber);
    }

    @Override
    public List<Applicant> getByEmail(String email) {
        String query = "SELECT * FROM applicants WHERE email = ?;";
        return get(query, email);
    }

    public List<Applicant> getByEmailAt(String email) {
        String query = "SELECT * FROM applicants WHERE email LIKE ?;";
        return get(query, email);
    }

    public List<Applicant> getByApplication(int application) {
        String query = "SELECT * FROM applicants WHERE application = ?;";
        return get(query, application);
    }

    private List<Applicant> getByQuery(String query, Object... values) {
        List<Applicant> applicants = new ArrayList<>();
        try (PreparedStatement stmt = c.prepareStatement(query)
        ) {
            setIntOrString(stmt, values);
            ResultSet results = stmt.executeQuery();
            fillList(results, applicants);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicants;
    }

    private void setIntOrString(PreparedStatement stmt, Object[] values) throws SQLException {
        int parameterIndex = 1;
        for (Object value : values) {
            if (value instanceof String) {
                stmt.setString(parameterIndex++, (String) value);
            } else if (value instanceof Integer) {
                stmt.setInt(parameterIndex++, (Integer) value);
            }
        }
    }

    private void fillList(ResultSet results, List<Applicant> applicants) throws SQLException {
        while (results.next()) {
            Applicant applicant = createApplicant(results);
            applicants.add(applicant);
        }
    }

    private List<Applicant> get(String query, Object... value) {
        return getByQuery(query, value);
    }

//    private List<Applicant> get(String column, Object value) {
//        List<Applicant> applicants = new ArrayList<>();
//        try (PreparedStatement stmt = c.prepareStatement("SELECT * FROM applicants WHERE " + column + " = ?;")
//        ) {
//            if (value instanceof String) {
//                stmt.setString(1, (String) value);
//            } else if (value instanceof Integer) {
//                stmt.setInt(1, (Integer) value);
//            }
//            ResultSet results = stmt.executeQuery();
//
//            while (results.next()) {
//                Applicant applicant = createApplicant(results);
//                applicants.add(applicant);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return applicants;
//    }

    private Applicant createApplicant(ResultSet results) throws SQLException {
        Applicant applicant = new Applicant();
        applicant.setId(results.getInt("id"));
        applicant.setFirstName(results.getString("first_name"));
        applicant.setLastName(results.getString("last_name"));
        applicant.setPhoneNumber(results.getString("phone_number"));
        applicant.setEmail(results.getString("email"));
        applicant.setApplicationCode(results.getInt("favourite_number"));
        return applicant;
    }

    @Override
    public boolean insert(Applicant applicant) {
        try {
            PreparedStatement stmt = c.prepareStatement(
                    "INSERT INTO applicants (first_name, last_name, phone_number, email, application)" +
                            " VALUES (?, ?, ?, ?, ?);");
            stmt.setString(1, applicant.getFirstName());
            stmt.setString(2, applicant.getLastName());
            stmt.setString(3, applicant.getPhoneNumber());
            stmt.setString(4, applicant.getEmail());
            stmt.setInt(5, applicant.getApplicationCode());
            stmt.executeUpdate();
            // TODO it might be better to return void here
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Applicant applicant) {
        try {
            PreparedStatement stmt = c.prepareStatement(
                    "UPDATE applicants" +
                            " SET first_name = ?," +
                            " last_name = ?," +
                            " phone_number = ?," +
                            " email = ?," +
                            " application = ?" +
                            " WHERE id = ?;");
            stmt.setString(1, applicant.getFirstName());
            stmt.setString(2, applicant.getLastName());
            stmt.setString(3, applicant.getPhoneNumber());
            stmt.setString(4, applicant.getEmail());
            stmt.setInt(5, applicant.getApplicationCode());
            stmt.setInt(6, applicant.getId());
            stmt.executeUpdate();
            // TODO it might be better to return void here
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Applicant applicant) {
        try {
            PreparedStatement stmt = c.prepareStatement("DELETE" +
                    " FROM applicants" +
                    " WHERE id = ?;");
            stmt.setInt(1, applicant.getId());
            stmt.executeUpdate();
            // TODO it might be better to return void here
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
