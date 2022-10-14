package com.studentreporting.repository;

import java.lang.Integer;

import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import javax.inject.Inject;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import com.studentreporting.repository.mapper.*;

import java.util.List;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

  public static Logger log = LoggerFactory.getLogger(StudentRepositoryImpl.class);
  @Inject private StudentMapper studentMapper;

  @Override
  public Student getStudent(Integer studentId) {
    return studentMapper.getStudent(studentId);
  }

  @Override
  public void deleteStudent(Integer studentId) {
    Student student = studentMapper.getStudent(studentId);
    if (student == null) {
      return;
    }

    studentMapper.deleteStudent(studentId);
  }

  @Override
  public void updateStudent(Student student) {
    Integer studentId = student.getId();
    Student existingStudent = studentMapper.getStudent(studentId);
    if (existingStudent == null) {
      throw new RuntimeException(
          String.format("Student with id {} does not exists", student.getId()));
    }
    studentMapper.updateStudent(student);
  }

  @Override
  public Integer createStudent(Student student) {
    studentMapper.createStudent(student);
    return student.getId();
  }
}
