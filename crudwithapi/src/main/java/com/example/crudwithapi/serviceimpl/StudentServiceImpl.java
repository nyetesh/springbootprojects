package com.example.crudwithapi.serviceimpl;

import com.example.crudwithapi.entity.Student;
import com.example.crudwithapi.repository.StudentRepository;
import com.example.crudwithapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllEmployees() {


        return studentRepository.findAll();
    }

    @Override

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();

    }

    @Override
    public Student updateStudent(Student student, int id) {


        Optional<Student> optional = studentRepository.findById(id);
        Student existingStudent = optional.get();
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setActiveStatus(student.getActiveStatus());
        existingStudent.setCourseEnrolled(student.getCourseEnrolled());

        studentRepository.save(existingStudent);

        return existingStudent;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }


}
