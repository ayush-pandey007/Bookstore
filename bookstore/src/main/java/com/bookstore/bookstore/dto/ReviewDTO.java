package com.bookstore.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {

    private Integer id;
    private String emailId;
    private String firstName;
    private String lastName;
    private BookDTO book;
    private double rating;
}
