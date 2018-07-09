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

import springmvctest.controller.form.RoleForm;
import springmvctest.pojo.Permission;
import springmvctest.service.PermissionService;
import springmvctest.service.RoleService;

@Controller
public class RoleController {
    private PermissionService permissionService;
    
    private RoleService roleService;
    
    @Autowired
    public RoleController(PermissionService permissionService,
                          RoleService roleService) {
        this.permissionService = permissionService;
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/roles/add")
    public String add(@ModelAttribute RoleForm roleForm, 
                      Model model) {
        prepareOptionsInAdd(model);
        return "role-add";
    }
    
    private void prepareOptionsInAdd(Model model) {
        List<Permission> permissionOptions = permissionService.findAllOptions();
        model.addAttribute("permissionOptions", permissionOptions);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/roles/add")
    public String create(@ModelAttribute @Valid RoleForm roleForm,
                         BindingResult bindingResult, 
                         Model model) {
        if (bindingResult.hasErrors()) {
            prepareOptionsInAdd(model);
            return "role-add";
        }
        
        roleService.create(roleForm.toRole());
        return "redirect:/roles/";
    }
}
