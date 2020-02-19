package com.gluecoders.databasesqlexample.dao;

import com.gluecoders.databasesqlexample.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
}
