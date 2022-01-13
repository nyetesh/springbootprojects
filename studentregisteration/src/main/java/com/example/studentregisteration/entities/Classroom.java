package com.example.studentregisteration.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classroom")
public class Classroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int classId;
    @Column(name = "class_name")
    private String className;
    @Column(name = "class_shift")
    private String classShift;
    @Column(name = "class_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date classStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "class_end_date")
    private Date classEndDate;


    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "classroom")
    private List<Course> course;


    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "classroom")
    private List<Student> studentList;

}
