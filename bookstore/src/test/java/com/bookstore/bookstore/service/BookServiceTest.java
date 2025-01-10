package com.bookstore.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.bookstore.bookstore.Repository.BookRepository;
import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.entity.Book;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private BookService bookService;

    private Book book;

    private BookDTO bookDTO;

    @BeforeEach
    void setup() {

        book = new Book();

        book.setBookId(1);
        book.setBookName("sample");
        

        bookDTO = new BookDTO();

        bookDTO.setId(1);
        bookDTO.setName("sample");
    }

    @Test
    void testFindAll() {
        
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDTO);

        List<BookDTO> result = bookService.findAll();

        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getName(), "sample");

        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testFindById_WhenBookExists() {

        when(bookRepository.findById(1)).thenReturn(Optional.of(book));
        when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDTO);

        BookDTO result= bookService.findById(1);

        assertNotNull(result);
        assertEquals(result.getId(), 1);
        assertEquals(result.getName(), "sample");

        verify(bookRepository, times(1)).findById(1);
    }

    @Test
    void testFindById_WhenBookNotExists() {

        when(bookRepository.findById(1)).thenReturn(Optional.empty());

        BookDTO result = bookService.findById(1);

        assertNull(result);
        
        verify(bookRepository, times(1)).findById(1);

    }

    @Test
    void testFindByTitle() {

        when(bookRepository.findByBookNameContainingIgnoreCase("sample")).thenReturn(Arrays.asList(book));
        when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDTO);

        List<BookDTO> result = bookService.findByTitle("sample");

        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getName(), "sample");

    }

    


}
