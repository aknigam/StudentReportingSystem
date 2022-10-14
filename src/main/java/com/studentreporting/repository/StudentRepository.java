package com.studentreporting.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import java.lang.Integer;

import java.util.List;

public interface StudentRepository {

  public Student getStudent(Integer studentId);

  public void deleteStudent(Integer studentId);

  public void updateStudent(Student student);

  public Integer createStudent(Student student);
}
