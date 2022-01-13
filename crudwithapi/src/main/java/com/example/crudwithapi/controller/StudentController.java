package com.example.crudwithapi.controller;

import com.example.crudwithapi.entity.Student;
import com.example.crudwithapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create student
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    //Get all employees api
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllEmployees();
    }

    //Get by id
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId){
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    //Update
    // /api/student/1/
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,
                                                 @RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student " + id + " deleted", HttpStatus.OK);
    }


}
