package springmvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.mapper.RoleMapper;
import springmvctest.pojo.Permission;
import springmvctest.pojo.Role;
import springmvctest.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;
    
    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> findAllOptions() {
        return roleMapper.findAllOptions();
    }

    @Override
    public void create(Role role) {
        roleMapper.create(role); // 保存角色名称、描述
        // 保存角色有哪些权限
        for (Permission permission : role.getPermissions()) {
            roleMapper.addPermission(role.getId(), permission.getId());
        }
    }

}
