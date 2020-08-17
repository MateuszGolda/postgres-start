package com.codecool.postgresstart;

import java.sql.Statement;

public interface Connection {
    void connect();

    Statement getStatement();

    Connection getConnection();
}
