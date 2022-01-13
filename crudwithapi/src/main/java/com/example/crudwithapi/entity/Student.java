package com.example.crudwithapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "active_status")
    private char activeStatus;
    @Column(name = "course_enrolled")
    private String courseEnrolled;

}
