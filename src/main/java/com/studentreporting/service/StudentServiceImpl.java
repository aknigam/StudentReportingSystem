package com.studentreporting.service;

import javax.inject.Inject;

import com.studentreporting.entities.*;

import com.studentreporting.repository.*;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;
import java.util.Optional;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
  public static Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

  @Inject private StudentRepository studentRepository;

  @Inject private ElasticsearchOperations elasticsearchTemplate;

  @Inject private StudentMarksRepository studentMarksRepository;

  @Inject private StudentESRepository repository;

  private int studentIdAutoIncrementCounter;

  private Map<Integer, Student> studentMap= new HashMap<>();

  public Student getStudent(Integer studentId) {
//    StudentMarks marks = new StudentMarks();
//    marks.setId(1);
//    marks.setMarks(56);
//    marks.setStudentName("Rajendra");
//    marks.setSemester("third");
//    marks.setSubject("Physics");
//    studentMarksRepository.save(marks);
    Optional<Student> student = repository.findById(studentId);
    return student.get();
  }

  public void deleteStudent(Integer studentId) {

    repository.deleteById(studentId);
//    Student student = getStudent(studentId);
//    studentRepository.deleteStudent(studentId);
  }

  public void updateStudent(Student student) {

    repository.save(student);

//    Student existingStudent = getStudent(student.getId());
//    studentRepository.updateStudent(student);
    return;
  }

  public Integer createStudent(Student student) {
    int id = ++studentIdAutoIncrementCounter;
    student.setId(id);
    repository.save(student);
//    Integer studentId = studentRepository.createStudent(student);
    return id;
  }
}
