package com.student.student.Repository;

import com.student.student.Model.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public class JPQLRepository{


  @Query("select s from Student S")
  public List<Student> findAll() {
    return null;
  }

  @Query("Insert into Student values ()")
  public void save() {
  }

  @Query("select s from Student s where s.id = ?1 ")
  public Optional<Student> findById(Long id) {
    return Optional.empty();
  }

  @Query("delete from Student where id = ?1")
  public void deleteById(Long id) {

  }
  @Query("select s from Student s where s.name like %?1%")
  public List<Student> findWhereNameLike(String name) {
  }
}
