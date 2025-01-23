package com.demo.service;

import java.util.List;

import com.demo.entity.Book;
import com.demo.entity.Book.Genre;
import org.springframework.stereotype.Service;


public interface BookService {
	void save(Book book);

	void update(Book book);

	void delete(Long id);

	Book findById(Long id);

	List<Book> findAll();

	List<Book> findByTitle(String title);

	List<Book> findByGenre(Genre genre);

	List<Book> findByAuthorId(Long authorId);

	List<Book> findByTitleAndGenreAndAuthorId(String title, Genre genre, Long authorId);
}