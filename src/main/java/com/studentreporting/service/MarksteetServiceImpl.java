package com.studentreporting.service;

import javax.inject.Inject;
import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import com.studentreporting.service.MarksteetService;
import com.studentreporting.repository.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class MarksteetServiceImpl implements MarksteetService {
  public static Logger log = LoggerFactory.getLogger(MarksteetServiceImpl.class);

  @Inject private StudentRepository studentRepository;
  @Inject private MarksteetRepository marksteetRepository;

  public Marksteet getMarksteet(Integer marksteetId) {
    Marksteet marksteet = marksteetRepository.getMarksteet(marksteetId);
    return marksteet;
  }

  public void deleteMarksteet(Integer marksteetId) {
    Marksteet marksteet = getMarksteet(marksteetId);
    marksteetRepository.deleteMarksteet(marksteetId);
  }

  public void updateMarksteet(Marksteet marksteet) {
    Marksteet existingMarksteet = getMarksteet(marksteet.getId());
    marksteetRepository.updateMarksteet(marksteet);
    return;
  }

  public Integer createMarksteet(Marksteet marksteet) {
    Integer marksteetId = marksteetRepository.createMarksteet(marksteet);
    return marksteetId;
  }
}
