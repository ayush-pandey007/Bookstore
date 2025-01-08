package com.bookstore.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entity.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview,Integer> {

}
