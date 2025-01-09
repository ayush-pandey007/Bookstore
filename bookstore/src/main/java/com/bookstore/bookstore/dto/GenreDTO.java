package com.bookstore.bookstore.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {

    private Integer id;
    private String description;
    private List<BookDTO> books;
}
