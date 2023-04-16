package com.example.demo.response;

import com.example.demo.request.BookRequest;
import com.example.demo.request.StudentRequest;
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
public class BookAllocationResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("student")
    private StudentResponse studentResponse;

    @NotNull
    @JsonProperty("book")
    private BookResponse bookResponse;
}
