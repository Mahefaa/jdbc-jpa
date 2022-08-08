package com.student.student.Repository.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCreator {
    public static Statement createStatement(Connection connection){
        Statement statement ;
        try{
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
    public static PreparedStatement createPreparedStatement(Connection connection, String sql){
        PreparedStatement statement ;
        try{
            statement=connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
}
