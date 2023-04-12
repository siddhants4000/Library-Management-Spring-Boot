package com.example.demo.entity;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int id;

    @NotNull
    @Column(name = "student_name")
    private String name;

    @NotNull
    @Column(name = "student_roll")
    private String roll;

}
