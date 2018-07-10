package springmvctest.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import springmvctest.pojo.Permission;
import springmvctest.pojo.Role;

public class RoleForm {
    private Long id; // 添加时为null，修改时才有值
    
    @Size(min = 1, max = 64, message = "1~64字")
    private String name;
    
    @Size(max = 128, message = "最多128字")
    private String description;
    
    private List<String> permissionIds = new ArrayList<>(); // 表单类接收关系时使用关系的主键列表
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getPermissionIds() {
        return permissionIds;
    }
    public void setPermissionIds(List<String> permissionIds) {
        this.permissionIds = permissionIds;
    }
    
    public Role toRole() {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setDescription(description);
        
        for (String permissionId : permissionIds) {
            Permission permission = new Permission();
            permission.setId(permissionId);
            role.getPermissions().add(permission);
        }
        
        return role;
    }
    public static RoleForm fromRole(Role role) {
        RoleForm roleForm = new RoleForm();
        roleForm.setId(role.getId());
        roleForm.setName(role.getName());
        roleForm.setDescription(role.getDescription());
        
        // 把角色实体的权限实体列表转换为表单对象的权限id列表
        for (Permission permission : role.getPermissions()) {
            roleForm.getPermissionIds().add(permission.getId());
        }
        
        return roleForm;
    }
}
