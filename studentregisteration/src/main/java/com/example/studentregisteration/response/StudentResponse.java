package com.example.studentregisteration.response;

import com.example.studentregisteration.entities.Course;
import com.example.studentregisteration.entities.Student;

import lombok.Getter;
import lombok.Setter;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class StudentResponse {

    public Map<String, Object> successResult(Student student, String message){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success","true");
        responseMap.put("message", message);

        Map<String, Object> studentDetails = new HashMap<>();

        studentDetails.put("studentId", student.getStudentId());
        studentDetails.put("studentName", student.getStudentName());
        studentDetails.put("activeStatus", student.getActiveStatus());
        studentDetails.put("mobileNo", student.getMobileNo());
        studentDetails.put("registeredDate", simpleDateFormat.format(student.getRegisteredDate()));
        studentDetails.put("emailAddress", student.getEmailAddress());

        responseMap.put("data", studentDetails);

        Map<String, Object> classDetails = new HashMap<>();
        classDetails.put("className",student.getClassroom().getClassName());
        classDetails.put("classShift", student.getClassroom().getClassShift());

        ArrayList<String> courseList = new ArrayList<>();
        for(Course course: student.getClassroom().getCourse()){
            courseList.add(course.getCourseName());
        }
        classDetails.put("courses", courseList);

        responseMap.put("classRoom",classDetails);

        return responseMap;
    }


    public Map<String,Object> failResult(String message){


        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success","false");
        responseMap.put("message", message);
        return  responseMap;
    }

    public Map<String, Object> deleteResponse(){
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", "true");
        responseMap.put("message", "Student deleted successfully");
        return responseMap;
    }

}
