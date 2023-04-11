package com.example.demo.controller;

import com.example.demo.entity.BookAllocation;
import com.example.demo.request.BookAllocationRequest;
import com.example.demo.service.BookAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allocate")
public class BookAllocationController {

    @Autowired
    BookAllocationService bookAllocationService;

    @PostMapping("/")
    public String allocateBook(@RequestBody BookAllocationRequest bookAllocationRequest) {
        return bookAllocationService.allocateBook(bookAllocationRequest.getStudentRequest(), bookAllocationRequest.getBookRequest());
    }
}
