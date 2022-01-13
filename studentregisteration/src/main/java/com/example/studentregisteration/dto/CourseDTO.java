package com.example.studentregisteration.dto;

import com.example.studentregisteration.entities.Classroom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CourseDTO {

    private int courseId;
    private String courseName;
    private String courseDuration;
    private char courseAvailability;
    private String courseDetails;
    private Classroom classroom;
    private int classId;

}
