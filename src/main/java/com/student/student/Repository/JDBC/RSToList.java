package com.student.student.Repository.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RSToList {
    public static List<String> resultToList(ResultSet resultSet, List<String> columns){
        List<String> result= new ArrayList<>();
        try{
            while(resultSet.next()){
                for (String column : columns) {
                    result.add(resultSet.getString(column));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
