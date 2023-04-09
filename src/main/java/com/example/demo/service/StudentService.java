package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    List<Student> students=new LinkedList<>();

    public Iterable<Student> getAllStudents() {
        return students.stream().collect(Collectors.toList());
    }

    public String addStudent(Student student) {
        String ans;
        if (!students.contains(student)) {
            ans = student.getName() + " is added successfully.";
            students.add(student);
        } else {
            ans = "Student  is already added.";
        }
        return ans;
    }
}
