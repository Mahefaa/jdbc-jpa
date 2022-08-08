package com.student.student.Repository.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManipulator {
    public static java.sql.Connection connect(String username, String password, String database){
        String url = "jdbc:postgresql://localhost:5432/"+database;
        java.sql.Connection con;
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    public static void disconnect(java.sql.Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void commit (java.sql.Connection connection){
        try {
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void rollback (Connection connection){
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
