package com.example.demo.repo;

import com.example.demo.entity.BookAllocation;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAllocationRepository extends JpaRepository<BookAllocation, Integer> , JpaSpecificationExecutor<BookAllocation>{

    BookAllocation findByStudent(Student student);
}
