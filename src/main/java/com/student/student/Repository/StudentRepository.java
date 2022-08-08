package com.student.student.Repository;

import com.student.student.Model.Student;
import com.student.student.Repository.JDBC.ConnectionManipulator;
import com.student.student.Repository.JDBC.RSToList;
import com.student.student.Repository.JDBC.StatementCreator;

import javax.swing.text.html.Option;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements StudentSimpleRepository {
  private StatementCreator stmCreator;
  private List<String> columns = List.of("id","name","group");
  private Statement stm = StatementCreator.createStatement(ConnectionManipulator.connect("test","test","student"));
  @Override
  public List<String> findAll() {
    try{
      ResultSet resultSet = stm.executeQuery("select * from student");
      return RSToList.resultToList(resultSet,columns);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void save(Student student) {
    try{
    stm.executeUpdate("insert into student('name','group') values ('"+student.getName()+"','"+student.getGroup().toString()+"'");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Optional<String> findById(long id) {
    try{
    ResultSet resultSet = stm.executeQuery("select * from student where id ="+id+" limit 0");
    List<String> list = RSToList.resultToList(resultSet,columns);
    return Optional.of(list.get(0));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteById(long id) {
    try{
    stm.executeUpdate("delete from student where id ="+id);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<String> findWhereNameLike(String name) {
    try{
    ResultSet resultSet = stm.executeQuery("select * from student where name like %"+name+"%;");
    RSToList.resultToList(resultSet,columns);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
