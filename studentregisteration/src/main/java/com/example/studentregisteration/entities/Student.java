package com.example.studentregisteration.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "active_status")
    private char activeStatus;
    @Column(name = "mobile_number")
    private String mobileNo;
    @Column(name = "registered_date")
    private Date registeredDate;
    @Column(name = "deleted_date")
    private Date recordDeleteDate;
    @Column(name = "deleted_remarks")
    private String recordDeleteRemarks;
    @Column(name = "modified_date")
    private Date modifiedDate;
    @Column(name = "modified_remarks")
    private String modifiedRemarks;
    @Column(name="email_address")
    private String emailAddress;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "verification_code", length =64)
    private String verificationCode;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}
