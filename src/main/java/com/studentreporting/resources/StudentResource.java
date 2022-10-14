package com.studentreporting.resources;

import com.studentreporting.entities.Student;
import com.studentreporting.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(
    path = "/studentreporting/v1/students",
    produces = "application/json",
    consumes = "application/json")
public class StudentResource {
  public static Logger log = LoggerFactory.getLogger(StudentResource.class);
  @Inject private StudentService studentService;

  public StudentResource() {}

  @PostMapping
  public Student createStudent(
      @NotNull(message = "Student is required") @Valid @RequestBody Student student) {
    Integer id = studentService.createStudent(student);
    Student var = studentService.getStudent(id);
    if (var == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Student could not be created due to bad request");
    }
    return var;
  }

  @PutMapping("/{studentId}")
  public void updateStudent(
      @PathVariable("studentId") Integer studentId,
      @NotNull(message = "Student is required for update") @Valid @RequestBody Student student) {
    student.setId(studentId);
    studentService.updateStudent(student);
  }

  @DeleteMapping("/{studentId}")
  public void deleteStudent(@PathVariable("studentId") Integer studentId) {
    studentService.deleteStudent(studentId);
  }

  @GetMapping("/{studentId}")
  public Student getStudent(@PathVariable("studentId") Integer studentId) {
    Student var = studentService.getStudent(studentId);
    if (var == null) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          String.format("Student with identifier %d does not exists", studentId));
    }
    return var;
  }
}
