package com.bookstore.bookstore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.entity.BookGenre;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre,Integer> {

    Optional<BookGenre> findByDescription(String description);
    List<BookGenre> findByDescriptionIn(List<String> descriptions);
}
