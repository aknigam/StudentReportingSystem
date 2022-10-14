package com.studentreporting.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "student-reporting", indexStoreType = "fs")
public class StudentMarks {

    private String studentName;

    private String semester;

    private String subject;

    private Integer marks;

    @Id
    private int id;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }
}
