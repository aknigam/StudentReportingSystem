package com.studentreporting.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;

import java.util.List;

public interface MarksteetRepository {

  public Marksteet getMarksteet(Integer marksteetId);

  public void deleteMarksteet(Integer marksteetId);

  public void updateMarksteet(Marksteet marksteet);

  public Integer createMarksteet(Marksteet marksteet);

  public void linkMarksteetStudent(Integer marksteetId, Integer studentId);

  public void unlinkMarksteetStudent(Integer marksteetId, Integer studentId);

  public void linkMarksteetSemester(Integer marksteetId, Integer semesterId);

  public void unlinkMarksteetSemester(Integer marksteetId, Integer semesterId);

  public void linkMarksteetSubject(Integer marksteetId, Integer subjectId);

  public void unlinkMarksteetSubject(Integer marksteetId, Integer subjectId);
}
