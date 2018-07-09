package springmvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvctest.mapper.PermissionMapper;
import springmvctest.pojo.Permission;
import springmvctest.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    private PermissionMapper permissionMapper;
    
    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> findAllOptions() {
        return permissionMapper.findAllOptions();
    }

}
