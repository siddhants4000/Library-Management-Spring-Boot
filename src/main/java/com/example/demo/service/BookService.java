package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.enums.StatusCode;
import com.example.demo.model.Status;
import com.example.demo.model.WrapperResponse;
import com.example.demo.repo.BookRepository;
import com.example.demo.request.BookRequest;
import com.example.demo.response.BookResponse;
import com.example.demo.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    LinkedHashMap<Book, Integer> books= new LinkedHashMap<>();

    @Autowired
    BookRepository bookRepository;

    public WrapperResponse<BookResponse> addBook(BookRequest bookRequest) {
        if(!bookRepository.findAll().contains(bookRequest)){
            bookRequest.setCopies(1L);
            Book newBook= Book.builder()
                    .name(bookRequest.getName())
                    .author(bookRequest.getAuthor())
                    .bookId(bookRequest.getBookId())
                    .copies(bookRequest.getCopies())
                    .build();
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Book has been added successfully.")
                    .success(Boolean.TRUE)
                    .build();

            bookRepository.save(newBook);

            return WrapperResponse.<BookResponse>builder()
                    .data(BookResponse.builder()
                            .id(newBook.getId())
                            .name(newBook.getName())
                            .author(newBook.getAuthor())
                            .bookId(newBook.getBookId())
                            .copies(newBook.getCopies())
                            .build())
                    .status(resultStatus)
                    .build();
        } else {
            bookRequest.setCopies(bookRequest.getCopies()+1L);
            Book newBook= Book.builder()
                    .name(bookRequest.getName())
                    .author(bookRequest.getAuthor())
                    .bookId(bookRequest.getBookId())
                    .copies(bookRequest.getCopies())
                    .build();
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Book has been added successfully.")
                    .success(Boolean.TRUE)
                    .build();

            bookRepository.save(newBook);

            return WrapperResponse.<BookResponse>builder()
                    .data(BookResponse.builder()
                            .id(newBook.getId())
                            .name(newBook.getName())
                            .author(newBook.getAuthor())
                            .bookId(newBook.getBookId())
                            .copies(newBook.getCopies())
                            .build())
                    .status(resultStatus)
                    .build();

        }
    }

    public LinkedHashMap<Book, Integer> getAllBooks() {
        return books.entrySet().stream().filter(e -> books.containsKey(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }

    public String searchBook(Book book) {
        if(bookRepository.findAll().contains(book)) {
            Long copies=bookRepository.findByBookId(book.getBookId()).getCopies();
            return book+" is in stock and has "+copies+" copies.";
        } else {
            return book+" is out of stock.";
        }
    }
}
