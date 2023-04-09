package com.example.demo.service;

import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    LinkedHashMap<Book, Integer> books= new LinkedHashMap<>();
    public String addBook(Book book) {
        if(!books.containsKey(book)){
            books.put(book, 1);
        } else {
            books.put(book, books.get(book)+1);
        }
        return book.getName()+" has been added. Copies available- "+books.get(book);
    }

    public LinkedHashMap<Book, Integer> getAllBooks() {
        return books.entrySet().stream().filter(e -> books.containsKey(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }

    public String searchBook(Book book) {
        if(books.containsKey(book)) {
            return book+" is in stock and has "+books.get(book)+" copies.";
        } else {
            return book+" is out of stock.";
        }
    }
}
