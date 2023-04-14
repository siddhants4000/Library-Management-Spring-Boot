package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookRequest {

    @NotNull
    private String name;

    @NotNull
    private String author;

    @NotNull
    private String bookId;

    @Nullable
    private Long copies;
}
