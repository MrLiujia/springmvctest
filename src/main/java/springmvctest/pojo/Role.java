package springmvctest.pojo;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private Long id;
    private String name;
    private String description;
    
    private List<Permission> permissions = new ArrayList<>(); // 对多关系
    
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
    
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
