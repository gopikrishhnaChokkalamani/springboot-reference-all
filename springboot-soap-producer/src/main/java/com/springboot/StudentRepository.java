package com.springboot;

import com.localsoapproducer.xml.school.Major;
import com.localsoapproducer.xml.school.Student;
import com.localsoapproducer.xml.school.StudentResponse;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRepository {

  private static final Map<String, Student> students = new HashMap<>();

  @PostConstruct
  public void initData() {
    Student student = new Student();
    student.setId(12);
    student.setMajor(Major.MATHS);
    student.setSchool("Public School");
    student.setName("john");

    students.put(student.getName(), student);
  }

  public Student getStudent(String name) {
    return students.get(name);
  }
}