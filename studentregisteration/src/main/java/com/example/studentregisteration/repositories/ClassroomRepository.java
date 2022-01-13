package com.example.studentregisteration.repositories;


import com.example.studentregisteration.entities.Classroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    @Query("select c From Classroom c WHERE c.classId =:n")
    Classroom getClassroomById(@Param("n") int id);
}
