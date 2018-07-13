package springmvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.config.UserDetailsImpl;
import springmvctest.mapper.RoleMapper;
import springmvctest.pojo.Permission;
import springmvctest.pojo.Role;
import springmvctest.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;
    
    private SessionRegistry sessionRegistry;
    
    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper,
                           SessionRegistry sessionRegistry) {
        this.roleMapper = roleMapper;
        this.sessionRegistry = sessionRegistry;
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
        
        // 将该角色的所有已登录用户退出
        logoutOperatorsOfRole(role);
    }

    private void logoutOperatorsOfRole(Role role) {
        List<Object> allLoginedPrincipals = sessionRegistry.getAllPrincipals();
        for (Object principal : allLoginedPrincipals) { // 遍历每一个已登录用户
            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            if (userDetails.getOperator().getRole().getId() == role.getId()) { // 该用户的角色已经被修改（权限可能被修改）
                List<SessionInformation> sessions = sessionRegistry.getAllSessions(principal, false);
                // 保守起见，将该用户的所有登录退出
                for (SessionInformation session : sessions) {
                    session.expireNow(); // 使会话失效
                }
            }
        }
    }

}
