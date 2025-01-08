package com.bookstore.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.BookGenre;

public interface BookGenreRepository extends JpaRepository<BookGenre,Integer> {

}
