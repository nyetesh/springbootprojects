package com.example.studentregisteration.service;

import com.example.studentregisteration.dto.ClassroomDTO;



import java.util.List;
import java.util.Map;

public interface ClassroomService {

    Map<String, Object> saveClassroom(ClassroomDTO classroomDTO);

    Map<String, Object> getAllClassroom();

    Map<String, Object> getClassroomById(int id);
}
