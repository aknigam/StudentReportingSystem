package com.studentreporting.service;

import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import java.util.List;
import java.lang.Integer;

public interface StudentService {

  public Student getStudent(Integer studentId);

  public void deleteStudent(Integer studentId);

  public void updateStudent(Student student);

  public Integer createStudent(Student student);
}
