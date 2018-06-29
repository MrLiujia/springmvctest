package springmvctest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return "publisher-add";
    }
}
