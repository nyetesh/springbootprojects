package com.example.studentregisteration.dto;

import com.example.studentregisteration.entities.Classroom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StudentDTO {


    private int studentId;
    private String studentName;
    private char activeStatus;
    private String mobileNo;
    private Date registeredDate;
    private Date recordDeleteDate;
    private String recordDeleteRemarks;
    private Date modifiedDate;
    private String modifiedRemarks;
    private String emailAddress;
    private Classroom classroom;
    private int classId;
}
