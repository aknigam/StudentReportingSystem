package com.studentreporting.entities;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.lang.Integer;
import java.lang.String;
import java.lang.Integer;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Document(indexName = "student")
public class Student {

  public Student() {}

  @Id
  private Integer id;

  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Student) {
      final Student other = (Student) obj;
      return Objects.equals(id, other.id);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
