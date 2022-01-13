package com.example.studentregisteration.serviceImpl;


import com.example.studentregisteration.dto.CourseDTO;
import com.example.studentregisteration.dtotoentity.CourseDTOtoEntity;
import com.example.studentregisteration.entities.Classroom;
import com.example.studentregisteration.entities.Course;
import com.example.studentregisteration.repositories.ClassroomRepository;
import com.example.studentregisteration.repositories.CourseRepository;
import com.example.studentregisteration.response.CourseResponse;
import com.example.studentregisteration.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@AllArgsConstructor
@NoArgsConstructor

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ClassroomRepository classroomRepository;


    @Override
    @Transactional
    public Map<String,Object> saveCourse(CourseDTO courseDTO) {

        CourseResponse courseResponse = new CourseResponse();
        CourseDTOtoEntity courseDTOtoEntity = new CourseDTOtoEntity();
        Course course = courseDTOtoEntity.courseDTOtoEntity(courseDTO);
        Classroom classroom = classroomRepository.getClassroomById(courseDTO.getClassId());
        course.setClassroom(classroom);

        return courseResponse.successResponse(courseRepository.save(course), "Course added successfully");
    }

    @Override
    public Map<String, Object> getAllCourses() {

        CourseResponse courseResponse = new CourseResponse();
        List<Course> courseList=  courseRepository.findAll();

        return courseResponse.courseList(courseList);
    }

    @Override
    public Map<String, Object> getCourseById(int id) {

        CourseResponse courseResponse = new CourseResponse();
        Course course = courseRepository.findCourseById(id);
        return courseResponse.successResponse(course, "");
    }

    @Override
    public Course updateCourse(Course student, int id) {
        return null;
    }

    @Override
    public void deleteCourse(int id) {
        Optional<Course> optional = courseRepository.findById(id);
        Course deleteCourse = optional.get();
        deleteCourse.setCourseAvailability('N');
        courseRepository.save(deleteCourse);
    }




}
