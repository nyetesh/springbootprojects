package com.example.studentregisteration.dto;

import com.example.studentregisteration.entities.Course;
import com.example.studentregisteration.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDTO {

    private int classId;
    private String className;
    private String classShift;
    private Date classStartDate;
    private Date classEndDate;
    private List<Course> course;
    private List<Student> studentList;

}
