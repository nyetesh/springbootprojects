package com.example.studentcrud.Entity;

import javax.persistence.*;

@Entity
public class Student {

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

    public Student() {
        super();
    }

    public Student(String studentName, String mobileNo, char activeStatus, String courseEnrolled) {

        this.studentName = studentName;
        this.mobileNo = mobileNo;
        this.activeStatus = activeStatus;
        this.courseEnrolled = courseEnrolled;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public char getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(char activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(String courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName=" + studentName +
                ", mobileNo='" + mobileNo + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                ", courseEnrolled='" + courseEnrolled + '\'' +
                '}';
    }
}
