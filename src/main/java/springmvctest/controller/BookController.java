package springmvctest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvctest.pojo.Author;
import springmvctest.pojo.Book;
import springmvctest.pojo.Publisher;
import springmvctest.service.AuthorService;
import springmvctest.service.BookService;
import springmvctest.service.PublisherService;

@Controller
public class BookController {   

	private BookService bookService;
	
	private AuthorService authorService;
	
	private PublisherService publisherService;

	@Autowired
    public BookController(BookService bookService, 
                          AuthorService authorService,
                          PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/book-list")
	public String list(Model model) {
		System.out.println("BookController.list");
		// 调用service获取图书列表
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books); // 把数据放到model（请求域）中以便jsp获取
		return "book-list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/book-details/{id}")
	public String details(@PathVariable Long id, Model model) {
	    Book book = bookService.findOne(id);
	    model.addAttribute("book", book);
	    return "book-details";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/add")
	// 注意：@ModelAttribute会用参数类名首字母小写作为model名，而不是同参数名
	public String add(@ModelAttribute Book book, Model model) {
	    prepareOptionsInAdd(model);
	    return "book-add";
	}

    private void prepareOptionsInAdd(Model model) {
        List<Author> authorOptions = authorService.findAllOptions();
	    List<Publisher> publisherOptions = publisherService.findAllOptions();
	    
	    Author authorPlaceholder = new Author();
	    authorPlaceholder.setName("--请选择作者--");
	    authorOptions.add(0, authorPlaceholder);
	    
	    Publisher publisherPlaceholder = new Publisher();
	    publisherPlaceholder.setName("--请选择出版社--");
	    publisherOptions.add(0, publisherPlaceholder);
	    
	    model.addAttribute("authorOptions", authorOptions);
	    model.addAttribute("publisherOptions", publisherOptions);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/books/add")
	public String create(@ModelAttribute @Valid Book book,
	                     BindingResult bindingResult, 
	                     Model model) {
        if (book.getPublisher() == null || book.getPublisher().getId() == null) {
            bindingResult.rejectValue("publisher.id", "required", "必填");
        }
        
	    if (bindingResult.hasErrors()) {
	        prepareOptionsInAdd(model);
	        return "book-add";
	    }
	    
	    System.out.println("book add: " + book.getTitle());
	    System.out.println("authors: " + book.getAuthors().size() + "个");
	    System.out.println("publisher: #" + book.getPublisher().getId());
	    bookService.create(book);
	    return "redirect:/books/book-list";
	}
}
