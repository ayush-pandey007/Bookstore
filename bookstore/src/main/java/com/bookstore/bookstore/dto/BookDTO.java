package com.bookstore.bookstore.dto;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private Integer id;
    private String name;
    private Set<AuthorDTO> authorName;
    private String price;
    private List<GenreDTO> genre;
    private List<ReviewDTO> reviews;
}
