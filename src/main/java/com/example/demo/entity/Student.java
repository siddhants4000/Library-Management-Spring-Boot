package com.example.demo.entity;

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
@Entity
@Table(name = "student")
public class Student {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Id
    @NotNull
    @Column(name = "roll")
    private String roll;

}
