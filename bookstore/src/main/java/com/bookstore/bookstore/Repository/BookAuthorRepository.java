package com.bookstore.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor,Integer> {

}
