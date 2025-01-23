package com.demo.Dao;

import java.util.List;

import com.demo.entity.Author;

public interface AuthorDAO {
	void save(Author author);

	void update(Author author);

	void delete(Long id);

	Author findById(Long id); 

	List<Author> findAll();
}