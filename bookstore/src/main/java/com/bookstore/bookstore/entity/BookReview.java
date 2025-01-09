package com.bookstore.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String emailId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book reviewedBooks;

    @Column(name = "rating")
    private Double rating;
}
