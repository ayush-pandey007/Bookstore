package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.Repository.BookRepository;
import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.entity.Book;

@Service
public class BookService {

    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(ModelMapper modelMapper,BookRepository bookRepository) {

        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAll() {

        List<Book> book = bookRepository.findAll();

        return book.stream().map(this::convertToBookDTO).collect(Collectors.toList());

       
    }

    public BookDTO findById(Integer bookId) {

        Optional<Book> books = bookRepository.findById(bookId);
        if (books.isPresent()) {
            Book book = books.get();
            return convertToBookDTO(book);
        } else {
            return null;
        }
    }

    private BookDTO convertToBookDTO(Book book) {

        return modelMapper.map(book, BookDTO.class);
    }
    
}
