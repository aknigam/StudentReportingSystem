package com.studentreporting.repository;

import com.studentreporting.entities.Marksteet;
import com.studentreporting.entities.Student;
import com.studentreporting.entities.StudentMarks;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StudentMarksRepository extends ElasticsearchRepository<StudentMarks, Integer> {
}
