package com.studentreporting.service;

import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import java.util.List;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;

public interface MarksteetService {

  public Marksteet getMarksteet(Integer marksteetId);

  public void deleteMarksteet(Integer marksteetId);

  public void updateMarksteet(Marksteet marksteet);

  public Integer createMarksteet(Marksteet marksteet);
}
