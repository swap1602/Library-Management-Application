package com.demo.Dao;

import java.util.List;

import com.demo.entity.Book;
import org.springframework.transaction.annotation.Transactional;


public interface BookDAO {
    void save(Book book);
    void update(Book book);
    void delete(Long id);
    Book findById(Long id);
    @Transactional
    List<Book> findAll();
    List<Book> findByTitle(String title);
    List<Book> findByGenre(Book.Genre genre); 
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByTitleAndGenreAndAuthorId(String title, Book.Genre genre, Long authorId);
}