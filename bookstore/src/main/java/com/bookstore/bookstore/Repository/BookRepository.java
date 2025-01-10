package com.bookstore.bookstore.Repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.BookGenre;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByBookNameContainingIgnoreCase(String query);

    List<Book> findByGenreContains(BookGenre genre);

}
