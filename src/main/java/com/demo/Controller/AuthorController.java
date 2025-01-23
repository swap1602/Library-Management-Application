package com.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entity.Author;
import com.demo.service.AuthorService;

import java.util.List;

@Controller
@RequestMapping("/libraryCrud")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping("/authors")
	public String listAuthors(Model model) {
		List<Author> authors = authorService.findAll();
		System.out.println("Authors: " + authors);
		model.addAttribute("authors", authors);
		return "authorList";
	}

	@RequestMapping("/createAuthor")
	public String showAddAuthorForm(Model model) {
		model.addAttribute("authors", new Author());
		return "authorForm";
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@Valid Author author, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "authorForm";
		}
		authorService.save(author);
		return "redirect:/libraryCrud/authors";
	}

	@RequestMapping("/editAuthor/{id}")
	public String showEditAuthorForm(@PathVariable Long id, Model model) {
		Author author = authorService.findById(id);
		model.addAttribute("authors", author);
		return "authorForm";
	}

	@RequestMapping(value = "/deleteAuthor/{id}", method = RequestMethod.POST)
	public String deleteAuthor(@PathVariable Long id) {
		authorService.delete(id);
		return "redirect:/libraryCrud/authors";
	}
}
