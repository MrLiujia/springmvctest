package springmvctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvctest.pojo.Book;
import springmvctest.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books/book-list")
	public String list(Model model) {
		System.out.println("BookController.list");
		// 调用service获取图书列表
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books); // 把数据放到model（请求域）中以便jsp获取
		
		return "book-list";
	}
}
