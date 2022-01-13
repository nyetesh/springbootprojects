package com.example.studentcrud.Repository;

import com.example.studentcrud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("select s From Student s WHERE s.studentName =:n")
    List<Student> getStudentByName(@Param("n") String name);
}
