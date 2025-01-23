package com.demo.service.impl;

import com.demo.Dao.BookDAO;
import com.demo.entity.Book;
import com.demo.entity.Book.Genre;
import com.demo.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

	@Autowired
	private BookDAO bookDAO;

	@Override
	public void save(Book book) {
		logger.info("Saving book: {}", book);
		bookDAO.save(book);
	}

	@Override
	public void update(Book book) {
		 logger.info("Updating book: {}", book); 
		bookDAO.update(book);
	}

	@Override
	public void delete(Long id) {
		 logger.warn("deleting book: {}"); 
		bookDAO.delete(id);
	}

	@Override
	public Book findById(Long id) {
		return bookDAO.findById(id);
	}

	@Override
	public List<Book> findAll() {
		return bookDAO.findAll();
	}

	@Override
	public List<Book> findByTitle(String title) {
		return bookDAO.findByTitle(title);
	}

	@Override
	public List<Book> findByGenre(Genre genre) {
		return bookDAO.findByGenre(genre);
	}

	@Override
	public List<Book> findByAuthorId(Long authorId) {
		return bookDAO.findByAuthorId(authorId);
	}

	@Override
	public List<Book> findByTitleAndGenreAndAuthorId(String title, Genre genre, Long authorId) {
		return bookDAO.findByTitleAndGenreAndAuthorId(title,genre,authorId);
	}
}