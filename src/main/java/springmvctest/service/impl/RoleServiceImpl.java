package springmvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvctest.mapper.RoleMapper;
import springmvctest.pojo.Role;
import springmvctest.service.RoleService;

@Service
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

}
