package springmvctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvctest.pojo.Author;
import springmvctest.service.AuthorService;

@Controller
public class AuthorController {
	
	private AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/authors/author-list")
	public String list(Model model) {
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors", authors);
		return "author-list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/authors/author-details/{id}")
	public String details(@PathVariable Long id, Model model) {
	    Author author = authorService.findOne(id);
	    model.addAttribute("author", author);
	    return "author-details";
	}
}
