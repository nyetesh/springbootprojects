package com.example.studentregisteration.repositories;

import com.example.studentregisteration.entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("select c From Course c WHERE c.courseAvailability ='Y'")
    List<Course> findAll();

    @Query("select c From Course c WHERE c.courseAvailability ='Y' AND c.id =:n")
    Course findCourseById(@Param("n")int id);
}
