package com.example.studentregisteration.controller;

import com.example.studentregisteration.dto.CourseDTO;
import com.example.studentregisteration.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
public class CourseController {

    @Autowired
    private CourseService courseService;



    @PostMapping("/create")
    public Map<String, Object> saveCourse(@RequestBody CourseDTO courseDTO){
        return (courseService.saveCourse(courseDTO));
    }

    @GetMapping
    public Map<String, Object> getAllCourse(){

        return courseService.getAllCourses();
    }

    //Get by id
    @GetMapping("{id}")
    public Map<String, Object> getCourseById(@PathVariable("id") int courseId){
        return (courseService.getCourseById(courseId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return new ResponseEntity<String>("Course " + id + " deleted", HttpStatus.OK);
    }


}
