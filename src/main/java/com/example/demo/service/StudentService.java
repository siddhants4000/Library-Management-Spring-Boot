package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.enums.StatusCode;
import com.example.demo.model.Status;
import com.example.demo.model.WrapperResponse;
import com.example.demo.repo.StudentRepository;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    List<Student> students=new LinkedList<>();

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public WrapperResponse<StudentResponse> addStudent(StudentRequest studentRequest) {
        Student student= studentRepository.findByStudentRoll(studentRequest.getRoll());
        if (Objects.isNull(student)) {
            Student newStudent= Student.builder()
                    .studentName(studentRequest.getName())
                    .studentRoll(studentRequest.getRoll())
                    .build();
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Student has been added successfully.")
                    .success(Boolean.TRUE)
                    .build();

            studentRepository.save(newStudent);

            return WrapperResponse.<StudentResponse>builder()
                    .data(StudentResponse.builder()
                            .id(newStudent.getId())
                            .name(newStudent.getStudentName())
                            .roll(newStudent.getStudentRoll())
                            .build())
                    .status(resultStatus)
                    .build();
        } else {
            Status resultStatus= Status.builder()
                    .code(StatusCode.BAD_REQUEST.getCode())
                    .message("Student With same roll already exists")
                    .success(Boolean.TRUE)
                    .build();
            return WrapperResponse.<StudentResponse>builder()
                    .status(resultStatus)
                    .build();
        }
    }
}
