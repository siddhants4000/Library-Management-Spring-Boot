package com.example.demo.request;

import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAllocationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @JsonProperty("student")
    private StudentRequest studentRequest;


    @JsonProperty("book")
    private BookRequest bookRequest;
}
