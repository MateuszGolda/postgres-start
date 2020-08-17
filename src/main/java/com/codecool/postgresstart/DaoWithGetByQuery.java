package com.codecool.postgresstart;

import java.util.List;

public interface DaoWithGetByQuery<T> extends Dao<T> {
    List<T> get(String query);
}
