package springmvctest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvctest.pojo.Operator;
import springmvctest.pojo.Role;
import springmvctest.service.OperatorService;
import springmvctest.service.RoleService;
import springmvctest.service.UsernameExistsException;

@Controller
public class OperatorController {
    private OperatorService operatorService;
    
    private RoleService roleService;
    
    @Autowired
    public OperatorController(OperatorService operatorService,
                              RoleService roleService) {
        this.operatorService = operatorService;
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/operators/add")
    public String add(@ModelAttribute Operator operator,
                      Model model) {
        prepareOptionsInAdd(model);
        return "operator-add";
    }

    private void prepareOptionsInAdd(Model model) {
        List<Role> roleOptions = roleService.findAllOptions();
        model.addAttribute("roleOptions", roleOptions);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/operators/add")
    public String create(@ModelAttribute @Valid Operator operator,
                         BindingResult bindingResult, 
                         Model model) {
        System.out.println("添加管理员：" + operator.getUsername());
        if (bindingResult.hasErrors()) {
           prepareOptionsInAdd(model);
           return "operator-add";
        }
        
        // 牢记：控制层只处理参数收集、数据校验之类的，至于处理业务的细节、步骤应该放在service层
        try {
            operatorService.create(operator);
        } catch (UsernameExistsException ex) {
            System.out.println(ex.getMessage());
            bindingResult.rejectValue( // 手动添加校验错误
                    "username", // 指定错误字段
                    "form.operatorAdd.usernameExists", // 错误码, i18n（国际化）
                    "用户名已占用" // 如果错误码对应的消息没有找到，则使用此默认消息
            );
            return "operator-add";
        }
        
        return "redirect:/operators/";
    }
}
