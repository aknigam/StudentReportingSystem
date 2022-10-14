package com.studentreporting.repository.mapper;

import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import java.lang.Integer;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {

  @Select(" SELECT id, name" + " FROM student" + " WHERE (id = #{studentId})")
  @Results({@Result(column = "id", property = "id"), @Result(column = "name", property = "name")})
  Student getStudent(@Param("studentId") Integer studentId);

  @Insert(" INSERT INTO student" + "  (name)" + " VALUES (#{student.name})")
  @Options(useGeneratedKeys = true, keyProperty = "student.id")
  void createStudent(@Param("student") Student student);

  @Update(" UPDATE student" + " SET name = #{student.name}" + " WHERE (id = #{student.id})")
  void updateStudent(@Param("student") Student student);

  @Delete(" DELETE FROM student" + " WHERE (id =  #{studentId})")
  void deleteStudent(@Param("studentId") Integer studentId);
}
