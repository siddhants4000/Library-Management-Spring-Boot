package com.example.demo.repo;

import com.example.demo.request.StudentRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentRequest, Integer> {

    boolean findByRoll(String student);
}
