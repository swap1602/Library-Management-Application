package com.demo.service;

import java.util.List;

import com.demo.entity.Author;
import org.springframework.stereotype.Service;


public interface AuthorService {
	void save(Author author);

	void update(Author author);

	void delete(Long id); 

	Author findById(Long id); 

	List<Author> findAll();
}