package com.example.studentregisteration.response;

import com.example.studentregisteration.entities.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseResponse {


    public Map<String, Object> successResponse(Course course, String message){

        Map<String, Object> courseResponseMap  = new HashMap<>();
        courseResponseMap.put("success", "true");
        if(message!="") {
            courseResponseMap.put("message", message);
        }
        Map<String, Object> courseDetails = new HashMap<>();
        courseDetails.put("courseName",course.getCourseName());
        courseDetails.put("courseId", course.getCourseId());
        courseDetails.put("courseDetails", course.getCourseDetails());

        courseResponseMap.put("data", courseDetails);

        courseResponseMap.put("classroom", course.getClassroom().getClassName());
        return courseResponseMap;
    }

    public Map<String, Object> courseList(List<Course> courseList){

        Map<String, Object> courseResponseMap = new HashMap<>();

        int count = 0;
        for(Course course:courseList) {
            count++;

            Map<String, Object> data = new HashMap<>();

            Map<String, Object> courseDetails = new HashMap<>();
            courseDetails.put("courseId", course.getCourseId());
            courseDetails.put("courseName", course.getCourseName());
            courseDetails.put("courseDetails", course.getCourseDetails());
            courseDetails.put("class",course.getClassroom().getClassName());
            data.put("course", courseDetails);
            courseResponseMap.put(String.valueOf(count), data);

        }
        return courseResponseMap;

    }


}
