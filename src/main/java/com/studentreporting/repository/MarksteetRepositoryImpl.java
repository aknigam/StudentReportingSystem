package com.studentreporting.repository;

import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;
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
public class MarksteetRepositoryImpl implements MarksteetRepository {

  public static Logger log = LoggerFactory.getLogger(MarksteetRepositoryImpl.class);
  @Inject private MarksteetMapper marksteetMapper;

  @Override
  public Marksteet getMarksteet(Integer marksteetId) {
    return marksteetMapper.getMarksteet(marksteetId);
  }

  @Override
  public void deleteMarksteet(Integer marksteetId) {
    Marksteet marksteet = marksteetMapper.getMarksteet(marksteetId);
    if (marksteet == null) {
      return;
    }

    marksteetMapper.deleteMarksteet(marksteetId);
  }

  @Override
  public void updateMarksteet(Marksteet marksteet) {
    Integer marksteetId = marksteet.getId();
    Marksteet existingMarksteet = marksteetMapper.getMarksteet(marksteetId);
    if (existingMarksteet == null) {
      throw new RuntimeException(
          String.format("Marksteet with id {} does not exists", marksteet.getId()));
    }
    marksteetMapper.updateMarksteet(marksteet);
  }

  @Override
  public Integer createMarksteet(Marksteet marksteet) {
    marksteetMapper.createMarksteet(marksteet);
    return marksteet.getId();
  }

  public void linkMarksteetStudent(Integer marksteetId, Integer studentId) {
    marksteetMapper.linkMarksteetStudent(marksteetId, studentId);
  }

  public void unlinkMarksteetStudent(Integer marksteetId, Integer studentId) {
    marksteetMapper.unlinkMarksteetStudent(marksteetId);
  }

  public void linkMarksteetSemester(Integer marksteetId, Integer semesterId) {
    marksteetMapper.linkMarksteetSemester(marksteetId, semesterId);
  }

  public void unlinkMarksteetSemester(Integer marksteetId, Integer semesterId) {
    marksteetMapper.unlinkMarksteetSemester(marksteetId);
  }

  public void linkMarksteetSubject(Integer marksteetId, Integer subjectId) {
    marksteetMapper.linkMarksteetSubject(marksteetId, subjectId);
  }

  public void unlinkMarksteetSubject(Integer marksteetId, Integer subjectId) {
    marksteetMapper.unlinkMarksteetSubject(marksteetId);
  }
}
