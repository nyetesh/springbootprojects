package com.example.studentregisteration.repositories;

import com.example.studentregisteration.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s From Student s WHERE s.activeStatus ='Y'")
    List<Student> findAll();

    @Query("select s From Student s WHERE s.activeStatus ='Y' AND s.id =:n")
    Student findStudentById(@Param("n")int id);

    @Query(value = "SELECT s FROM Student s WHERE s.verificationCode = ?1")
    Student findByVerificationCode(String code);
}
