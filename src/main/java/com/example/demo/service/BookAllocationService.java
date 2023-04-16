package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookAllocation;
import com.example.demo.entity.Student;
import com.example.demo.enums.StatusCode;
import com.example.demo.model.Status;
import com.example.demo.model.WrapperResponse;
import com.example.demo.repo.BookAllocationRepository;
import com.example.demo.request.BookAllocationRequest;
import com.example.demo.request.BookRequest;
import com.example.demo.request.StudentRequest;
import com.example.demo.response.BookAllocationResponse;
import com.example.demo.response.BookResponse;
import com.example.demo.response.StudentResponse;
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

    public WrapperResponse<BookAllocationResponse> allocateBook(BookAllocationRequest bookAllocationRequest) {
        String bookId= bookAllocationRequest.getBookId();
        String studentRoll= bookAllocationRequest.getStudentRoll();

        Book book= bookService.bookRepository.findByBookId(bookId);
        Student student= studentService.studentRepository.findByStudentRoll(studentRoll);

        WrapperResponse bookAllocationResult= new WrapperResponse();
        if(!Objects.isNull(bookAllocationRepository.findByStudent(student))) {
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Book is already allocated to "+ student.getStudentName()+" with roll number "+ student.getStudentRoll())
                    .success(Boolean.TRUE)
                    .build();

            bookAllocationResult= WrapperResponse.<BookAllocationResponse>builder()
                    .status(resultStatus)
                    .build();

        } else if(bookService.bookRepository.findAll().contains(book) && bookService.bookRepository.findByBookId(book.getBookId()).getCopies()>0 && Objects.isNull(bookAllocationRepository.findByStudent(student)) && studentService.studentRepository.findAll().contains(student)) {
            book.setCopies(book.getCopies()-1L);
            BookAllocation bookAllocation= BookAllocation.builder()
                    .student(student)
                    .book(book)
                    .build();

            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message(book.getBookName()+ " is allocated to "+ student.getStudentName()+" with roll number "+ student.getStudentRoll())
                    .success(Boolean.TRUE)
                    .build();

            bookAllocationRepository.save(bookAllocation);
            bookAllocationResult= WrapperResponse.<BookAllocationResponse>builder()
                    .data(BookAllocationResponse.builder()
                            .studentResponse(StudentResponse.builder()
                                    .id(student.getId())
                                    .name(student.getStudentName())
                                    .roll(student.getStudentRoll())
                                    .build())
                            .bookResponse(BookResponse.builder()
                                    .id(book.getId())
                                    .name(book.getBookName())
                                    .author(book.getBookAuthor())
                                    .bookId(book.getBookId())
                                    .copies(book.getCopies())
                                    .build())
                            .build())
                    .status(resultStatus)
                    .build();

        } else if (!bookService.bookRepository.findAll().contains(book) || bookService.bookRepository.findByBookId(book.getBookId()).getCopies()<1) {
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Book is out of stock. Please choose another book.")
                    .success(Boolean.TRUE)
                    .build();

            bookAllocationResult= WrapperResponse.<BookAllocationResponse>builder()
                    .status(resultStatus)
                    .build();

        } else if (!studentService.studentRepository.findAll().contains(student)) {
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Student does not exist.")
                    .success(Boolean.TRUE)
                    .build();

            bookAllocationResult= WrapperResponse.<BookAllocationResponse>builder()
                    .status(resultStatus)
                    .build();
        }
        return bookAllocationResult;
    }
}
