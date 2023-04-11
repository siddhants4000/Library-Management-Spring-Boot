package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.repo.BookAllocationRepository;
import com.example.demo.request.BookRequest;
import com.example.demo.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Objects;

@Service
public class BookAllocationService {

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Autowired
    BookAllocationRepository bookAllocationRepository;

    LinkedHashMap<Student, Book> allocated= new LinkedHashMap<>();
    public String allocateBook(StudentRequest studentRequest, BookRequest bookRequest) {

        String ans = null;
        Student student= Student.builder()
                .name(studentRequest.getName())
                .roll(studentRequest.getRoll())
                .build();

        Book book= Book.builder()
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .bookId(bookRequest.getBookId())
                .copies(bookRequest.getCopies())
                .build();

        if(allocated.containsKey(student)) {
            ans="Book is already allocated to "+ student.getName()+" with roll number "+ student.getRoll();
        } else if(bookService.bookRepository.findAll().contains(book) && bookService.bookRepository.findByBookId(book.getBookId()).getCopies()>0 && Objects.isNull(bookAllocationRepository.findByStudent(student)) && studentService.studentRepository.findAll().contains(student)) {
            bookService.books.put(book, bookService.books.get(book)-1);
            allocated.put(student, book);
            ans=book.getName()+ " is allocated to "+ student.getName()+" with roll number "+ student.getRoll();
        } else if (!bookService.bookRepository.findAll().contains(book) || bookService.bookRepository.findByBookId(book.getBookId()).getCopies()<1) {
            ans= book.getName()+" is out of stock. Please choose another book.";
        } else if (!studentService.studentRepository.findAll().contains(student)) {
            ans="Student does not exist.";
        }
        return ans;
    }
}
