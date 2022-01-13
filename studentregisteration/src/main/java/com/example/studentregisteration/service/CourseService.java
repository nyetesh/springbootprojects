package com.example.studentregisteration.service;

import com.example.studentregisteration.dto.CourseDTO;
import com.example.studentregisteration.entities.Course;


import java.util.List;
import java.util.Map;

public interface CourseService {

    Map<String, Object> saveCourse(CourseDTO courseDTO);

    Map<String, Object> getAllCourses();

    Map<String, Object> getCourseById(int id);

    Course updateCourse(Course student, int id);

    void deleteCourse(int id);
}
