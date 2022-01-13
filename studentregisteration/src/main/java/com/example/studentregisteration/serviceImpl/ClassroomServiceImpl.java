package com.example.studentregisteration.serviceImpl;

import com.example.studentregisteration.dto.ClassroomDTO;
import com.example.studentregisteration.dtotoentity.ClassroomDTOtoEntity;
import com.example.studentregisteration.entities.Classroom;
import com.example.studentregisteration.repositories.ClassroomRepository;
import com.example.studentregisteration.response.ClassRoomResponse;
import com.example.studentregisteration.service.ClassroomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    @Transactional
    public Map<String, Object> saveClassroom(ClassroomDTO classroomDTO) {

        ClassRoomResponse classRoomResponse = new ClassRoomResponse();
        ClassroomDTOtoEntity classroomDTOtoEntity = new ClassroomDTOtoEntity();

        Classroom classroom = classroomDTOtoEntity.classroomDTOtoEntity(classroomDTO);
        String message = "Classroom created successfully";


        return classRoomResponse.classroomResponse(classroomRepository.save(classroom), message);
    }

    @Override
    public Map<String, Object> getAllClassroom() {

        List<Classroom> classroomList =  classroomRepository.findAll();
        ClassRoomResponse classRoomResponse = new ClassRoomResponse();
        return classRoomResponse.listAllClass(classroomList);
    }


    @Override
    public Map<String, Object> getClassroomById(int id) {

        ClassRoomResponse classRoomResponse = new ClassRoomResponse();
        Optional<Classroom> optional  = classroomRepository.findById(id);
        Classroom classroom = optional.get();
        return  classRoomResponse.classroomResponse(classroom, "");
    }


}
