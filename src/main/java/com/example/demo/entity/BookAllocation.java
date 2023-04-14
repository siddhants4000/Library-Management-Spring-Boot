package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book_allocation")
@JsonIgnoreProperties
public class BookAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnoreProperties
    @OneToOne
    @MapsId("id")
    private Student student;

    @JsonIgnoreProperties
    @OneToOne
    @MapsId("id")
    private Book book;

    @Column(name = "student_roll")
    private String studentRoll;

    @Column(name = "book_id")
    private String bookId;
}
