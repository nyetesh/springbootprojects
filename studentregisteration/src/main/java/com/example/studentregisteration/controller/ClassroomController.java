package com.example.studentregisteration.controller;

import com.example.studentregisteration.dtotoentity.ClassroomDTOtoEntity;
import com.example.studentregisteration.dto.ClassroomDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.studentregisteration.service.ClassroomService;


import java.util.Map;

@RestController
@RequestMapping("/api/classroom")
@AllArgsConstructor
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private ClassroomDTOtoEntity classroomDTOtoEntity;
    @Autowired


    //Create Class

    @PostMapping("/create")
    public Map<String, Object> saveClassroom(@RequestBody ClassroomDTO classroomDTO){
        return (classroomService.saveClassroom((classroomDTO)));
    }

    @GetMapping
    public Map<String, Object> getAllCourse(){
        return classroomService.getAllClassroom();
    }

    //Get by id
    @GetMapping("{id}")
    public Map<String, Object> getClassroomById(@PathVariable("id") int classId){
        return (classroomService.getClassroomById(classId));
    }
}
