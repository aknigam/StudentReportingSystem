package com.studentreporting.clients;

import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;
import java.lang.Integer;

public interface StudentClient {

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @POST("/studentreporting/v1/planner/students")
  Call<Student> createStudent(@Body Student student);

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @PUT("/studentreporting/v1/planner/students/{studentId}")
  Call<Void> updateStudent(@Path("studentId") Integer studentId, @Body Student student);

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @DELETE("/studentreporting/v1/planner/students/{studentId}")
  Call<Void> deleteStudent(@Path("studentId") Integer studentId);

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @GET("/studentreporting/v1/planner/students/{studentId}")
  Call<Student> getStudent(@Path("studentId") Integer studentId);
}
