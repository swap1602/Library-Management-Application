package com.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import com.demo.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.Book;
import com.demo.service.AuthorService;
import com.demo.service.BookService;

@Controller
@RequestMapping("/libraryCrud")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping("/books")
	public String listBooks(Model model) {
		List<Book> books = bookService.findAll();
		System.out.println("Books: " + books);
		model.addAttribute("books", books);
		return "bookList";
	}

	@RequestMapping("/createBook")
	public String showAddBookForm(Model model) {
		model.addAttribute("books", new Book());
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors", authors);
		return "bookForm";
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@Valid Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Author> authors = authorService.findAll();
			model.addAttribute("authors", authors);
			return "bookForm";
		}
		bookService.save(book);
		return "redirect:/libraryCrud/books";
	}

	@RequestMapping("/editBook/{bookId}")
	public String showEditBookForm(@PathVariable Long bookId, Model model) {
		Book book = bookService.findById(bookId);
		model.addAttribute("books", book);
		model.addAttribute("authors", authorService.findAll());
		return "bookForm";
	}

	@RequestMapping(value = "/deleteBook/{bookId}", method = RequestMethod.POST)
	public String deleteBook(@PathVariable Long bookId) {
		bookService.delete(bookId);
		return "redirect:/libraryCrud/books";
	}

	@RequestMapping("/search")
	public String searchBooks(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "genre", required = false) Book.Genre genre,
			@RequestParam(value = "authorId", required = false) Long authorId, Model model) {
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors", authors);
		List<Book> books;
		if (title != null && !title.isEmpty() && genre != null && authorId != null) {
			books = bookService.findByTitleAndGenreAndAuthorId(title, genre, authorId);
		}
		else if (title != null && !title.isEmpty()) {
			books = bookService.findByTitle(title);
		}
		else if (genre != null) {
			books = bookService.findByGenre(genre);
		}
		else if (authorId != null) {
			books = bookService.findByAuthorId(authorId);
		}
		else {
			books = bookService.findAll();
		}

		if (books.isEmpty()) {
			model.addAttribute("message", "No books found matching the search criteria.");
		}

		model.addAttribute("books", books);
		return "bookList";
	}
}
