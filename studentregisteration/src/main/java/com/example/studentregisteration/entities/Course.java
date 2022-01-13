package com.example.studentregisteration.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name="course_duration")
    private String courseDuration;
    @Column(name="course_availability")
    private char courseAvailability;
    @Column(name = "course_details")
    private String courseDetails;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;



}
