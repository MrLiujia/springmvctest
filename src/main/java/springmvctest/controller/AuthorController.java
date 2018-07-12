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
import springmvctest.service.AuthorService;

@Controller
public class AuthorController {
	
	private AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/authors/")
	public String list(Model model) {
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors", authors);
		return "author-list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/authors/{id}")
	public String details(@PathVariable Long id, Model model) {
	    Author author = authorService.findOne(id);
	    model.addAttribute("author", author);
	    return "author-details";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/authors/add")
	public String add(@ModelAttribute Author author) {
	    return "author-edit";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/authors/add")
	//                                   @Valid告诉springmvc需要校验Author
	//                   BindingResult参数必须紧随@Valid参数；如果省略了bindingResult参数，springmvc将直接返回400（Bad request）
    public String create(@ModelAttribute @Valid Author author, 
                         BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	        return "author-edit";
	    }
	    
	    // 数据校验通过才能走service
        authorService.create(author);
        return "redirect:/authors/";
    }
	
    @RequestMapping(method = RequestMethod.GET, value = "/authors/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Author author = authorService.findOne(id);
        model.addAttribute("author", author);
        return "author-edit";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/authors/{id}/edit")
    public String update(@ModelAttribute @Valid Author author,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author-edit";
        }
        
        authorService.update(author);
        return "redirect:/authors/";
    }
}
