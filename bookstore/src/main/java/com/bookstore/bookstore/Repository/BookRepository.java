package com.bookstore.bookstore.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.bookstore.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
