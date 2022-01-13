package com.example.crudwithapi.repository;

import com.example.crudwithapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {


}
