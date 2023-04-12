package com.example.demo.repo;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookAllocation;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAllocationRepository extends JpaRepository<Student, Book> {

    BookAllocation findByRoll(Student student);
}
