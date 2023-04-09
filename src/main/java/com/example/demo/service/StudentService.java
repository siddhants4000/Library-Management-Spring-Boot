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
import java.util.stream.Collectors;

@Service
public class StudentService {

    List<Student> students=new LinkedList<>();

    @Autowired
    StudentRepository studentRepository;

    public WrapperResponse<StudentResponse> getAllStudents() {
        return (WrapperResponse<StudentResponse>) studentRepository.findAll();
    }

    public WrapperResponse<StudentResponse> addStudent(StudentRequest studentRequest) {
        if (!studentRepository.findByRoll(studentRequest.getRoll())) {
            studentRepository.save(studentRequest);
            return WrapperResponse.<StudentResponse>builder()
                    .data(new StudentResponse(studentRequest.getId(), studentRequest.getName(), studentRequest.getRoll()))
                    .status(Status.builder().build())
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
