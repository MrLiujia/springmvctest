package springmvctest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvctest.pojo.Publisher;
import springmvctest.service.PublisherService;

@Controller
public class PublisherController {

    private PublisherService publisherService;
    
    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/publishers/add")
    public String add() {
        return "publisher-add";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/publishers/add")
    public String create(@RequestParam String name,
                         @RequestParam String description) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setDescription(description);
        
        publisherService.create(publisher);
        // 重定向(302) - redirect:目标路径，注意springmvc会自动加上“协议://主机:端口/项目名”
        return "redirect:/publishers/publisher-list";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/publishers/publisher-list")
    public String list(Model model) {
        List<Publisher> publishers = publisherService.findAll();
        model.addAttribute("publishers", publishers);
        return "publisher-list";
    }
}
