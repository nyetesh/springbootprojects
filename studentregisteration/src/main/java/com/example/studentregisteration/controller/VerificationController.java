package com.example.studentregisteration.controller;

import com.example.studentregisteration.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/verify")
    private ResponseEntity<String> verifyStudent(@Param("code") String code){

        if(studentService.verifyStudent(code)){
            return new ResponseEntity<String>("Verified", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Not Verified", HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
