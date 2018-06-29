package springmvctest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvctest.service.OperatorService;

@Controller
public class OperatorController {
    private OperatorService operatorService;
    
    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/operators/add")
    public String add() {
        return "operator-add";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/operators/add")
    //                   @RequestParam获取表单字段值，注意参数名要同字段名
    public String create(@RequestParam String username, @RequestParam String password) {
        System.out.println("添加管理员：" + username);
        operatorService.create(username, password);
        return "operator-add";
    }
}
