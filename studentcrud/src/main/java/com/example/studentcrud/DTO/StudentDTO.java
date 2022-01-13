package com.example.studentcrud.DTO;

import javax.persistence.Column;

public class StudentDTO {


    private String studentName;
    private String mobileNo;
    private char activeStatus;
    private String courseEnrolled;

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


}
