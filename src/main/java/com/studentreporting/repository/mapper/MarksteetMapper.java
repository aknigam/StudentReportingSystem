package com.studentreporting.repository.mapper;

import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MarksteetMapper {

  @Select(
      " SELECT id, student_id, semester_id, subject_id, marks"
          + " FROM marksteet"
          + " WHERE (id = #{marksteetId})")
  @Results({
    @Result(column = "id", property = "id"),
    @Result(column = "student_id", property = "student.id"),
    @Result(
        column = "semester_id",
        property = "semester",
        javaType = Semester.class,
        typeHandler = SemesterHandler.class),
    @Result(
        column = "subject_id",
        property = "subject",
        javaType = Subject.class,
        typeHandler = SubjectHandler.class),
    @Result(column = "marks", property = "marks")
  })
  Marksteet getMarksteet(@Param("marksteetId") Integer marksteetId);

  @Insert(
      " INSERT INTO marksteet"
          + "  (student_id, semester_id, subject_id, marks)"
          + " VALUES (#{marksteet.student.id}, #{marksteet.semester.id}, #{marksteet.subject.id}, #{marksteet.marks})")
  @Options(useGeneratedKeys = true, keyProperty = "marksteet.id")
  void createMarksteet(@Param("marksteet") Marksteet marksteet);

  @Update(
      " UPDATE marksteet"
          + " SET student_id = #{marksteet.student.id}, semester_id = #{marksteet.semester.id}, subject_id = #{marksteet.subject.id}, marks = #{marksteet.marks}"
          + " WHERE (id = #{marksteet.id})")
  void updateMarksteet(@Param("marksteet") Marksteet marksteet);

  @Delete(" DELETE FROM marksteet" + " WHERE (id =  #{marksteetId})")
  void deleteMarksteet(@Param("marksteetId") Integer marksteetId);

  @Update(" UPDATE marksteet" + " SET student_id = null" + " WHERE (id= #{marksteetId})")
  void unlinkMarksteetStudent(Integer marksteetId);

  @Update(" UPDATE marksteet" + " SET student_id = #{studentId}" + " WHERE (id = #{marksteetId} )")
  void linkMarksteetStudent(
      @Param("marksteetId") Integer marksteetId, @Param("studentId") Integer studentId);

  @Update(" UPDATE marksteet" + " SET semester_id = null" + " WHERE (id= #{marksteetId})")
  void unlinkMarksteetSemester(Integer marksteetId);

  @Update(
      " UPDATE marksteet" + " SET semester_id = #{semesterId}" + " WHERE (id = #{marksteetId} )")
  void linkMarksteetSemester(
      @Param("marksteetId") Integer marksteetId, @Param("semesterId") Integer semesterId);

  @Update(" UPDATE marksteet" + " SET subject_id = null" + " WHERE (id= #{marksteetId})")
  void unlinkMarksteetSubject(Integer marksteetId);

  @Update(" UPDATE marksteet" + " SET subject_id = #{subjectId}" + " WHERE (id = #{marksteetId} )")
  void linkMarksteetSubject(
      @Param("marksteetId") Integer marksteetId, @Param("subjectId") Integer subjectId);
}
