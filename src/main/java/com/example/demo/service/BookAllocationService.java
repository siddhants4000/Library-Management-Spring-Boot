//package com.example.demo.service;
//
//import com.example.demo.entity.Book;
//import com.example.demo.entity.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.LinkedHashMap;
//
//@Service
//public class BookAllocationService {
//
//    @Autowired
//    BookService bookService;
//
//    @Autowired
//    StudentService studentService;
//
//    LinkedHashMap<Student, Book> allocated= new LinkedHashMap<>();
//    public String allocateBook(Student student, Book book) {
//        String ans = null;
//        if(allocated.containsKey(student)) {
//            ans="Book is already allocated to "+ student.getName()+" with roll number "+ student.getRoll()+" and class "+ student.getStudentClass();
//        } else if(bookService.books.containsKey(book) &&bookService.books.get(book)>0 && !allocated.containsKey(student) && studentService.students.contains(student)) {
//            bookService.books.put(book, bookService.books.get(book)-1);
//            allocated.put(student, book);
//            ans=book.getName()+ " is allocated to "+ student.getName()+" with roll number "+ student.getRoll()+" and class "+ student.getStudentClass(); ;
//        } else if (!bookService.books.containsKey(book) || bookService.books.get(book)<1) {
//            ans= book.getName()+" is out of stock. Please choose another book.";
//        } else if (!studentService.students.contains(student)) {
//            ans="Student does not exist.";
//        }
//        return ans;
//    }
//}
