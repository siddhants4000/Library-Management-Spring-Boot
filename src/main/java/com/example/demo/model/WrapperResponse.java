package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WrapperResponse<T> {

    private Status status;

    private T data;
}
