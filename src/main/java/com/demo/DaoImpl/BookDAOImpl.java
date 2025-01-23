package com.demo.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.Dao.BookDAO;
import com.demo.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Book book) {
		getCurrentSession().saveOrUpdate(book);
	}

	@Override
	public void update(Book book) {
		getCurrentSession().update(book);
	}

	@Override
	public void delete(Long id) {
		Book book = findById(id);
		if (book != null) {
			getCurrentSession().delete(book);
		}
	}

	@Override
	public Book findById(Long id) {
		return getCurrentSession().get(Book.class, id);
	}

	@Override
	public List<Book> findAll() {
		return getCurrentSession().createQuery("from Book", Book.class).list();
	}

	@Override
	public List<Book> findByTitle(String title) {
		return getCurrentSession().createQuery("from Book where title like :title", Book.class)
				.setParameter("title", "%" + title + "%").list();
	}

	@Override
	public List<Book> findByGenre(Book.Genre genre) {
		return getCurrentSession().createQuery("from Book where genre = :genre", Book.class)
				.setParameter("genre", genre).list();
	}

	@Override
	public List<Book> findByAuthorId(Long authorId) {
		return getCurrentSession().createQuery("from Book where author.id = :authorId", Book.class)
				.setParameter("authorId", authorId).list();
	}

	@Override
	public List<Book> findByTitleAndGenreAndAuthorId(String title, Book.Genre genre, Long authorId) {
		StringBuilder queryString = new StringBuilder("FROM Book b WHERE 1=1");

		if (title != null && !title.isEmpty()) {
			queryString.append(" AND b.title LIKE :title");
		}

		if (genre != null) {
			queryString.append(" AND b.genre = :genre");
		}

		if (authorId != null) {
			queryString.append(" AND b.author.id = :authorId");
		}

		Query<Book> query = getCurrentSession().createQuery(queryString.toString(), Book.class);

		// Set parameters dynamically
		if (title != null && !title.isEmpty()) {
			query.setParameter("title", "%" + title + "%");  // Use LIKE for title search
		}

		if (genre != null) {
			query.setParameter("genre", genre);
		}

		if (authorId != null) {
			query.setParameter("authorId", authorId);
		}

		// Execute the query and return the list of books
		return query.list();
	}


}