package com.student.student.Repository.JDBC;

public class Import {
    public static void importDriver(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
