package com.example.studentcrud.DTO;

import com.example.studentcrud.Entity.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDTOToEntity {

    public Student convertDTOToEntity(StudentDTO studentDTO){

        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return student;


    }
}
