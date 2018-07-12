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
    public String add(@ModelAttribute Publisher publisher) {
        return "publisher-edit";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/publishers/add")
    //                   把表单字段封装成表单bean（new Publisher, setName, setDescription）
    //                   注意：表单字段名要同pojo属性名，没有字段对应属性将是默认值，不识别的字段将被忽略
    public String create(@ModelAttribute @Valid Publisher publisher, 
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "publisher-edit";
        }
        publisherService.create(publisher);
        // 重定向(302) - redirect:目标路径，注意springmvc会自动加上“协议://主机:端口/项目名”
        return "redirect:/publishers/";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/publishers/")
    public String list(Model model) {
        List<Publisher> publishers = publisherService.findAll();
        model.addAttribute("publishers", publishers);
        return "publisher-list";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/publishers/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.findOne(id);
        model.addAttribute("publisher", publisher);
        return "publisher-edit";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/publishers/{id}/edit")
    public String update(@ModelAttribute @Valid Publisher publisher, 
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "publisher-edit";
        }
        publisherService.update(publisher);
        return "redirect:/publishers/";
    }
}
