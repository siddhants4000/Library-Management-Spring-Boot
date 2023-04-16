package com.example.demo.request;

import lombok.*;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAllocationRequest {

    @NotNull
    private String studentRoll;

    @NotNull
    private String bookId;

}
