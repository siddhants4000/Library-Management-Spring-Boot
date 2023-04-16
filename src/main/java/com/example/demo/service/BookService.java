package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.enums.StatusCode;
import com.example.demo.model.Status;
import com.example.demo.model.WrapperResponse;
import com.example.demo.repo.BookRepository;
import com.example.demo.request.BookRequest;
import com.example.demo.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    LinkedHashMap<Book, Integer> books= new LinkedHashMap<>();

    @Autowired
    BookRepository bookRepository;

    public WrapperResponse<BookResponse> addBook(BookRequest bookRequest) {
        if(Objects.isNull(bookRepository.findByBookId(bookRequest.getBookId()))){
            bookRequest.setCopies(1L);
            Book newBook= Book.builder()
                    .bookName(bookRequest.getName())
                    .bookAuthor(bookRequest.getAuthor())
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
                            .name(newBook.getBookName())
                            .author(newBook.getBookAuthor())
                            .bookId(newBook.getBookId())
                            .copies(newBook.getCopies())
                            .build())
                    .status(resultStatus)
                    .build();
        } else {
            Book newBook= bookRepository.findByBookId(bookRequest.getBookId());
            newBook.setCopies(newBook.getCopies()+1L);
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Book has been added successfully.")
                    .success(Boolean.TRUE)
                    .build();

            bookRepository.save(newBook);

            return WrapperResponse.<BookResponse>builder()
                    .data(BookResponse.builder()
                            .id(newBook.getId())
                            .name(newBook.getBookName())
                            .author(newBook.getBookAuthor())
                            .bookId(newBook.getBookId())
                            .copies(newBook.getCopies())
                            .build())
                    .status(resultStatus)
                    .build();

        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public WrapperResponse<BookResponse> searchBook(BookRequest bookRequest) {
        WrapperResponse bookResult= new WrapperResponse();
        try{
            Book newBook= Book.builder()
                    .bookName(bookRequest.getName())
                    .bookAuthor(bookRequest.getAuthor())
                    .bookId(bookRequest.getBookId())
                    .copies(bookRequest.getCopies())
                    .build();
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Book has been found successfully.")
                    .success(Boolean.TRUE)
                    .build();
            if(bookRepository.findAll().contains(newBook)) {
                bookResult= WrapperResponse.<BookResponse>builder()
                        .data(BookResponse.builder()
                                .id(newBook.getId())
                                .name(newBook.getBookName())
                                .author(newBook.getBookAuthor())
                                .bookId(newBook.getBookId())
                                .copies(newBook.getCopies())
                                .build())
                        .status(resultStatus)
                        .build();
            }
        }catch (NullPointerException e) {
            Status resultStatus= Status.builder()
                    .code(StatusCode.SUCCESS.getCode())
                    .message("Book is out of Stock")
                    .success(Boolean.TRUE)
                    .build();
            bookResult= WrapperResponse.<BookResponse>builder()
                    .status(resultStatus)
                    .build();
        }
        return bookResult;
    }
}
