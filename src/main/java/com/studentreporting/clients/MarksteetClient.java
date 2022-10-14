package com.studentreporting.clients;

import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;

public interface MarksteetClient {

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @POST("/studentreporting/v1/planner/marksteets")
  Call<Marksteet> createMarksteet(@Body Marksteet marksteet);

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @PUT("/studentreporting/v1/planner/marksteets/{marksteetId}")
  Call<Void> updateMarksteet(@Path("marksteetId") Integer marksteetId, @Body Marksteet marksteet);

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @DELETE("/studentreporting/v1/planner/marksteets/{marksteetId}")
  Call<Void> deleteMarksteet(@Path("marksteetId") Integer marksteetId);

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @GET("/studentreporting/v1/planner/marksteets/{marksteetId}")
  Call<Marksteet> getMarksteet(@Path("marksteetId") Integer marksteetId);
}
