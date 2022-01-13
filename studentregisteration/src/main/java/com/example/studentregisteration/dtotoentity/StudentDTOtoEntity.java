package com.example.studentregisteration.dtotoentity;

import com.example.studentregisteration.dto.StudentDTO;

import com.example.studentregisteration.entities.Student;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StudentDTOtoEntity {


    public Student studentDTOtoEntity(StudentDTO studentDTO){

        Student student = new Student();

        student.setStudentName(studentDTO.getStudentName());
        student.setActiveStatus(studentDTO.getActiveStatus());
        student.setMobileNo(studentDTO.getMobileNo());
        student.setRegisteredDate(new Date());
        student.setModifiedDate(studentDTO.getModifiedDate());
        student.setEmailAddress(studentDTO.getEmailAddress());
        student.setRecordDeleteDate(studentDTO.getRecordDeleteDate());

        return student;
    }

}
