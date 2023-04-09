package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponse {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("author")
    private String author;

    @Id
    @NotNull
    @JsonProperty("book_id")
    private String bookId;
    
}