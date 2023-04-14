package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("student_name")
    private String name;

    @NotNull
    @JsonProperty("student_roll")
    private String roll;

}
