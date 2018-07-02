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
    //                   把表单字段封装成表单bean（new Publisher, setName, setDescription）
    //                   注意：表单字段名要同pojo属性名，没有字段对应属性将是默认值，不识别的字段将被忽略
    public String create(Publisher publisher) {
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
