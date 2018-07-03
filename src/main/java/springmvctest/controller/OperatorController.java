package springmvctest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvctest.pojo.Operator;
import springmvctest.service.OperatorService;

@Controller
public class OperatorController {
    private OperatorService operatorService;
    
    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/operators/add")
    public String add(@ModelAttribute Operator operator) {
        return "operator-add";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/operators/add")
    //                   @RequestParam获取表单字段值，注意参数名要同字段名
    public String create(@ModelAttribute @Valid Operator operator,
                         BindingResult bindingResult) {
        System.out.println("添加管理员：" + operator.getUsername());
        if (bindingResult.hasErrors()) {
           return "operator-add";
        }
        
        if (operatorService.usernameExists(operator.getUsername())) {
           bindingResult.rejectValue( // 手动添加校验错误
                   "username", // 指定错误字段
                   "form.operatorAdd.usernameExists", // 错误码, i18n（国际化）
                   "用户名已占用" // 如果错误码对应的消息没有找到，则使用此默认消息
                   );
           return "operator-add";
        }
        
        operatorService.create(operator.getUsername(), operator.getPassword());
        return "redirect:/operators/";
    }
}
