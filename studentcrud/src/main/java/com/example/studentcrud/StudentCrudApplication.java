package com.example.studentcrud;

import com.example.studentcrud.DTO.StudentDTO;

import com.example.studentcrud.DTO.StudentDTOToEntity;
import com.example.studentcrud.Entity.Student;
import com.example.studentcrud.Repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StudentCrudApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(StudentCrudApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);

		//create
		studentRepository.save(addStudent());

		//update
		updateStudent(studentRepository);

		//read
		listStudentById(studentRepository);
		listStudent(studentRepository);

		listStudentByName(studentRepository);

		//delete
		deleteStudent(studentRepository);
	}

	private static Student addStudent() {

		StudentDTOToEntity studentDTOToEntity = new StudentDTOToEntity();
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("MAX");
		studentDTO.setMobileNo("3432321215");
		studentDTO.setCourseEnrolled("C");
		studentDTO.setActiveStatus('Y');
		return studentDTOToEntity.convertDTOToEntity(studentDTO);

	}

	public static void updateStudent(StudentRepository studentRepository){
		Optional<Student> optional1 = studentRepository.findById(1);
		Student student1 = optional1.get();
		student1.setStudentName("Samrat");
		studentRepository.save(student1);
	}

	public static void listStudentById(StudentRepository studentRepository){
		//List student by id
		Optional<Student> optional = studentRepository.findById(2);
		Student student = optional.get();
		System.out.println(student);
	}

	public static void listStudent(StudentRepository studentRepository){
		//list students
		Iterable<Student> itr = studentRepository.findAll();
		itr.forEach(student2 -> {
			System.out.println(student2);
		} );
	}

	public static void listStudentByName(StudentRepository studentRepository){
		//ListStudent using jpql
		List<Student> studentByName = studentRepository.getStudentByName("Binay");
		for (Student stu : studentByName) {
			System.out.println(stu);
		}
	}

	public static void deleteStudent(StudentRepository studentRepository){
		studentRepository.deleteById(2);
	}
}
