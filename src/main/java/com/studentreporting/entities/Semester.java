package com.studentreporting.entities;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;
import java.lang.String;
import java.lang.Integer;
import javax.validation.constraints.*;
import javax.validation.Valid;

public enum Semester {
  FIRST(1, "first"),
  SECOND(2, "second");

  Semester(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  private static final Map<Integer, Semester> idToSemester = new HashMap();

  static {
    for (Semester semester : values()) idToSemester.put(semester.getId(), semester);
  }

  public static Semester fromId(Integer id) {
    return idToSemester.get(id);
  }

  private Integer id;

  private String name;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
