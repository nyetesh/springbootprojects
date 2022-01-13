package com.example.studentregisteration.service;

import com.example.studentregisteration.dto.StudentDTO;
import com.example.studentregisteration.entities.Student;


import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

import java.util.Map;

public interface StudentService {

    Map<String, Object> saveStudent(StudentDTO studentdto, String siteURL) throws UnsupportedEncodingException, MessagingException;

//    List<Student> getAllStudents();

    Map<String, Object> getStudentById(int id);

    Map<String, Object> updateClass(StudentDTO studentDTO, int id);

    void deleteStudent(int id);

    void sendVerificationEmail(Student student, String siteUrl) throws MessagingException, UnsupportedEncodingException;

    boolean verifyStudent(String verificationCode);

}
