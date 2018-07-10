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

    @Override
    public Role findOne(Long id) {
        return roleMapper.findOne(id);
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role); // 保存角色名称、描述
        // 保存角色有哪些权限
        // 假设角色a有权限1,2,3
        // a 1
        // a 2
        // a 3
        // 先把旧关系从中间表删除
        roleMapper.deleteAllPermissionsOfRole(role.getId());
        
        // 要把角色a的权限改为3,4,5
        // a 3
        // a 4
        // a 5
        // 再把新关系插入中间表
        for (Permission permission : role.getPermissions()) {
            roleMapper.addPermission(role.getId(), permission.getId());
        }
    }

}
