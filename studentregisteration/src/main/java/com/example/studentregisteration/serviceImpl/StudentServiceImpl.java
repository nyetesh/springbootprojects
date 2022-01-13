package com.example.studentregisteration.serviceImpl;

import com.example.studentregisteration.dto.StudentDTO;
import com.example.studentregisteration.dtotoentity.StudentDTOtoEntity;
import com.example.studentregisteration.entities.Classroom;
import com.example.studentregisteration.entities.Student;

import com.example.studentregisteration.repositories.ClassroomRepository;
import com.example.studentregisteration.repositories.StudentRepository;
import com.example.studentregisteration.response.StudentResponse;
import com.example.studentregisteration.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Transactional
    public Map<String, Object> saveStudent(StudentDTO studentDTO, String siteUrl) throws
            UnsupportedEncodingException, MessagingException{

            StudentResponse studentResponse = new StudentResponse();

            StudentDTOtoEntity studentDTOtoEntity = new StudentDTOtoEntity();

            if(verifyMobileNumber(studentDTO.getMobileNo())) {

                Student student = studentDTOtoEntity.studentDTOtoEntity(studentDTO);
                Classroom classroom = classroomRepository.getClassroomById(studentDTO.getClassId());
                student.setClassroom(classroom);

                String randomCode = RandomString.make(64);
                student.setVerificationCode(randomCode);
                student.setEnabled(false);

                Student student1 = studentRepository.save(student);

                sendVerificationEmail(student1, siteUrl);

                String message = "student enrolled successfully";

                return studentResponse.successResult(student1,message);
        }
            else{
                String message = "failed to enroll student";
                return studentResponse.failResult(message);
            }
    }


    @Override
    public Map<String, Object> getStudentById(int id) {
        StudentResponse studentResponse = new StudentResponse();
        Student student = studentRepository.findStudentById(id);
        return studentResponse.successResult(student, "");
    }

    @Override
    public Map<String, Object> updateClass(StudentDTO studentDTO, int id) {

        StudentResponse studentResponse = new StudentResponse();

        Student updateStudent = studentRepository.findStudentById(id);
        Classroom classroom = classroomRepository.getClassroomById(studentDTO.getClassId());
        updateStudent.setClassroom(classroom);
        String message = "Update successful";

        return studentResponse.successResult(studentRepository.save(updateStudent), message);

    }

    @Override
    public void deleteStudent(int id) {

        Optional<Student> optional = studentRepository.findById(id);
        Student deleteStudent = optional.get();
        deleteStudent.setActiveStatus('N');
        studentRepository.saveAndFlush(deleteStudent);

    }

    @Override
    public void sendVerificationEmail(Student student, String siteUrl)
    throws MessagingException, UnsupportedEncodingException {
        String toAddress = student.getEmailAddress();
        String fromAddress = "nitesh@springboot.com";
        String senderName = "Student Register Firm";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Student Register Office";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", student.getStudentName());
        String verifyURL = siteUrl + "/verify?code=" + student.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        javaMailSender.send(message);
    }

    @Override
    public boolean verifyStudent(String verificationCode){
        Student student = studentRepository.findByVerificationCode(verificationCode);
        if(student == null || student.isEnabled()){
            return false;
        }
        else{
            student.setEnabled(true);
            studentRepository.saveAndFlush(student);
            return true;
        }
    }

    public boolean verifyMobileNumber(String phoneNumber){

        return phoneNumber.matches("[9][8][0-2 4-6]{1}[0-9]{7}$");
    }


}
