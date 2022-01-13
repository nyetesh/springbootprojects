package com.example.studentregisteration.dtotoentity;

import com.example.studentregisteration.dto.ClassroomDTO;
import com.example.studentregisteration.entities.Classroom;

import org.springframework.stereotype.Component;

@Component
public class ClassroomDTOtoEntity {


    public Classroom classroomDTOtoEntity(ClassroomDTO classroomDTO){

        Classroom classroom = new Classroom();

        classroom.setClassName(classroomDTO.getClassName());
        classroom.setClassShift(classroomDTO.getClassShift());
        classroom.setClassStartDate(classroomDTO.getClassStartDate());
        classroom.setClassEndDate(classroomDTO.getClassEndDate());
        return classroom;


    }
}
