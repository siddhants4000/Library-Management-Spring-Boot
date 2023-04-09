package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.model.WrapperResponse;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public WrapperResponse<StudentResponse> addStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @GetMapping("/all")
    public WrapperResponse<StudentResponse> displayAllStudents() {
        return studentService.getAllStudents();
    }

}
