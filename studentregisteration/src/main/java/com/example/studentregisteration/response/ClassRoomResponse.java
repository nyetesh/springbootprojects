package com.example.studentregisteration.response;

import com.example.studentregisteration.entities.Classroom;
import com.example.studentregisteration.entities.Course;
import com.example.studentregisteration.entities.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRoomResponse {

    public Map<String, Object> classroomResponse(Classroom classroom, String message){


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success","true");

        if(message != "") {
            responseMap.put("message", message);
        }
        Map<String, Object> classroomDetails = new HashMap<>();

        classroomDetails.put("classId", classroom.getClassId());
        classroomDetails.put("className", classroom.getClassName());
        classroomDetails.put("shift", classroom.getClassShift());
        classroomDetails.put("startDate", simpleDateFormat.format(classroom.getClassStartDate()));
        responseMap.put("data", classroomDetails);

        ArrayList<String> courseList = new ArrayList<>();
        for(Course course: classroom.getCourse()){
            courseList.add(course.getCourseName());
        }
        responseMap.put("courseDetails", courseList);

        ArrayList<String> studentList = new ArrayList<>();
        for(Student student: classroom.getStudentList()){
            studentList.add(student.getStudentName());
        }

        responseMap.put("studentDetails", studentList);

        return responseMap;

    }

    public Map<String, Object> listAllClass(List<Classroom> classroomList){

        Map<String, Object> classResponseMap = new HashMap<>();

        int count = 0;
        for(Classroom classroom:classroomList) {
            count++;

            Map<String, Object> data = new HashMap<>();

            Map<String, Object> classroomDetails = new HashMap<>();
            classroomDetails.put("classId", classroom.getClassId());
            classroomDetails.put("className", classroom.getClassName());
            classroomDetails.put("classShift", classroom.getClassShift());

            ArrayList<String> courses = new ArrayList<>();
            for(Course course : classroom.getCourse()){
                courses.add(course.getCourseName());
            }
            classroomDetails.put("courses",courses);
            data.put("classroom", classroomDetails);
            classResponseMap.put(String.valueOf(count), data);

        }
        return classResponseMap;
    }
}
