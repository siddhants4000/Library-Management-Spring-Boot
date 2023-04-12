package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "bookAllocation")
public class BookAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotNull
    @OneToOne
    @MapsId("roll")
    @JoinColumn(name = "student_roll")
    private Student student;

    @NotNull
    @OneToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

}
