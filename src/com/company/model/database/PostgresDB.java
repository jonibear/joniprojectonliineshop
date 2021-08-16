package com.company.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionURL, "postgres", "Bekasex2217");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}