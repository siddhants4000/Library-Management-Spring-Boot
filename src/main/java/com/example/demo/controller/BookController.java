package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.model.WrapperResponse;
import com.example.demo.request.BookRequest;
import com.example.demo.response.BookResponse;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public WrapperResponse<BookResponse> addBook(@RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }

    @GetMapping("/all")
    public List<Book> displayAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/search")
    public WrapperResponse<BookResponse> searchBook(@RequestBody BookRequest bookRequest) {
        return bookService.searchBook(bookRequest);
    }
}
