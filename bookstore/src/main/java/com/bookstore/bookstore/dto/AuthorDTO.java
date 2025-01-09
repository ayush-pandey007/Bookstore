package com.bookstore.bookstore.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDTO {

    private Integer id;
    private String authorName;
    private Set<BookDTO> books;
}
