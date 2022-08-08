package com.student.student.Repository;

import com.student.student.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentSimpleRepository {
  List<String> findAll();

  void save(Student student);

  Optional<String> findById(long id);

  void deleteById(long id);

  List<String> findWhereNameLike(String name);
}
