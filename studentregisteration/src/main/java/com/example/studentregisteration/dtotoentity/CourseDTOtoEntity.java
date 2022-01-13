package com.example.studentregisteration.dtotoentity;


import com.example.studentregisteration.dto.CourseDTO;

import com.example.studentregisteration.entities.Course;
import com.example.studentregisteration.serviceImpl.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDTOtoEntity {


    @Autowired
    private ClassroomServiceImpl classroomService;

    public Course courseDTOtoEntity(CourseDTO courseDTO){

        Course course = new Course();

        course.setCourseName(courseDTO.getCourseName());
        course.setCourseAvailability(courseDTO.getCourseAvailability());
        course.setCourseDetails(courseDTO.getCourseDetails());
        course.setCourseDuration(courseDTO.getCourseDuration());

        return course;
    }
}
