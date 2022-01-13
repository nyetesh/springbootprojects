package com.example.studentregisteration.controller;

import com.example.studentregisteration.dto.StudentDTO;
import com.example.studentregisteration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

import java.util.Map;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Map<String,Object> saveStudent(@RequestBody StudentDTO studentDTO, HttpServletRequest request) throws
            UnsupportedEncodingException, MessagingException {
        return (studentService.saveStudent(studentDTO,getSiteURL(request)));
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }


    //Get by id
    @GetMapping("{id}")
    public Map<String, Object> getStudentById(@PathVariable("id") int studentId){
        return (studentService.getStudentById(studentId));
    }


    @PutMapping("/updateclass/{id}")
    public Map<String, Object> updateClass(@PathVariable("id") int id,
                                                 @RequestBody StudentDTO studentDTO){
        return(studentService.updateClass(studentDTO, id));
    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student " + id + " deleted", HttpStatus.OK);
    }

}
