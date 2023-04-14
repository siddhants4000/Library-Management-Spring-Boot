package com.example.demo.request;

import lombok.*;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAllocationRequest {

    private StudentRequest studentRequest;

    private BookRequest bookRequest;

}
