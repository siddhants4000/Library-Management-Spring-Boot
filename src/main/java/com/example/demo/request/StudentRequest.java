package com.example.demo.request;

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
public class StudentRequest {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @Id
    @NotNull
    @JsonProperty("roll")
    private String roll;

}
