package com.demo.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.Dao.AuthorDAO;
import com.demo.entity.Author;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Author author) {
		getCurrentSession().saveOrUpdate(author);
	}

	@Override
	public void update(Author author) {
		getCurrentSession().update(author);
	}

	@Override
	public void delete(Long id) {
		Author author = findById(id);
		if (author != null) {
			getCurrentSession().delete(author);
		}
	}

	@Override
	public Author findById(Long id) {
		return getCurrentSession().get(Author.class, id);
	}

	@Override
	public List<Author> findAll() {
		return getCurrentSession().createQuery("from Author", Author.class).list();
	}
}