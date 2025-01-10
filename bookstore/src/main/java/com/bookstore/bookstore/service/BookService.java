package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.Repository.BookGenreRepository;
import com.bookstore.bookstore.Repository.BookRepository;
import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.dto.GenreDTO;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.BookGenre;

import jakarta.transaction.Transactional;

@Service
public class BookService {

    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;
    private final BookGenreRepository bookGenreRepository;

    @Autowired
    public BookService(ModelMapper modelMapper,BookRepository bookRepository,BookGenreRepository bookGenreRepository) {

        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.bookGenreRepository = bookGenreRepository;
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

    public List<BookDTO> findByTitle(String query) {

        List<Book> book = bookRepository.findByBookNameContainingIgnoreCase(query);

        return book.stream().map(this::convertToBookDTO).collect(Collectors.toList());

    }

    public List<BookDTO> findAllByGenre(String query) {

        Optional<BookGenre> genre = bookGenreRepository.findByDescription(query);

        if(genre.isEmpty())return null;

        return bookRepository.findByGenreContains(genre.get()).stream().map(this::convertToBookDTO).collect(Collectors.toList());
    }

    @Transactional
    public BookDTO addBook(BookDTO bookDTO) {

        Book book = convertTBook(bookDTO);
        List<String> list = bookDTO.getGenre().stream().map(GenreDTO::getDescription).collect(Collectors.toList());
        List<BookGenre> genres = bookGenreRepository.findByDescriptionIn(list);

        book.setGenre(genres);
        genres.forEach(genre -> genre.getBooks().add(book));
        Book savedBook = bookRepository.save(book);
        return convertToBookDTO(savedBook);
    }
    @Transactional
    public void deleteBookById(Integer bookId) {

        bookRepository.deleteById(bookId);
    }

    private BookDTO convertToBookDTO(Book book) {

        return modelMapper.map(book, BookDTO.class);
    }

    private Book convertTBook(BookDTO bookDTO) {

        return modelMapper.map(bookDTO, Book.class);
    }




    
}
