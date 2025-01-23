package com.demo.service.impl;

import com.demo.Dao.AuthorDAO;
import com.demo.entity.Author;
import com.demo.service.AuthorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

	@Autowired
	private AuthorDAO authorDAO;

	@Override
	public void save(Author author) {
		logger.info("Saving Author: {}", author);
		authorDAO.save(author);
	}

	@Override
	public void update(Author author) {
		logger.info("Updating Author: {}", author);
		authorDAO.update(author);
	}

	@Override
	public void delete(Long id) {
		logger.warn("deleting Author: {}");

		authorDAO.delete(id);
	}

	@Override
	public Author findById(Long id) {
		return authorDAO.findById(id);
	}

	@Override
	public List<Author> findAll() {
		return authorDAO.findAll();
	}
}