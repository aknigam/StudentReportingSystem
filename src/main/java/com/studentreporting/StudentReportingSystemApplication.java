package com.studentreporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StudentReportingSystemApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {

    SpringApplication app = new SpringApplication(StudentReportingSystemWebConfig.class);
    app.run(StudentReportingSystemApplication.class, args);
  }
}
