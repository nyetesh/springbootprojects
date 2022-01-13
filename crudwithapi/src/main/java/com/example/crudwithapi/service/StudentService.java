package com.example.crudwithapi.service;

import com.example.crudwithapi.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllEmployees();

    Student getStudentById(int id);

    Student updateStudent(Student student, int id);

    void deleteStudent(int id);
}


