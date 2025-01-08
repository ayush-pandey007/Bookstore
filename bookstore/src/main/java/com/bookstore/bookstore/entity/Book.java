package com.bookstore.bookstore.entity;



import java.util.List;
import java.util.Set;


import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
public class Book {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer bookId;

    @Column(name = "title")
    private String bookName;

    
    @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
    private Set<BookAuthor> author;

    @Column(name="price")
    private String price;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<BookGenre> genre;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    private List<BookReview> reviews;


    
 

}
