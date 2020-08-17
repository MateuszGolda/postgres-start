package com.codecool.postgresstart;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();

    List<T> getByFirstName(String firstName);

    List<T> getByLastName(String lastName);

    List<T> getByPhoneNumber(String phoneNumber);

    List<T> getByEmail(String email);

    Optional<T> getById(int id);

    boolean insert(T t);

    boolean update(T t);

    boolean delete(T t);
}
