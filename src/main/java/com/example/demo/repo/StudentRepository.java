package com.example.demo.repo;

import com.example.demo.entity.Student;
import com.example.demo.request.StudentRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentRequest, Integer> {

    Student findByRoll(String roll);
}
