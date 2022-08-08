package com.student.student.Controller;

import com.student.student.Model.Group;
import com.student.student.Model.Student;
import com.student.student.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class StudentController {
  private StudentRepository studentRepository;
  @GetMapping("/students")
  public List<String> getStudents(){
    return studentRepository.findAll();
  }
  @GetMapping("/students/{id}")
  public Student getStudent(@PathVariable Long id){
    return studentRepository.findById(id).orElse(new Student());
  }
  @GetMapping("/groups")
  public List<Group> getGroups(){
    return List.of(new Group());
  }
  @PostMapping
  public List<Student> createStudents(@RequestBody List<Student> studentList){
    return List.of(new Student());
  }
  @PutMapping
  public Student putStudent(@RequestBody Student student){
    return new Student();
  }
  @PatchMapping
  public Student patchStudent(@RequestBody Student student){
    return new Student();
  }
}
