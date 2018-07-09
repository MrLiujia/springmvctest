package springmvctest.service;

import java.util.List;

import springmvctest.pojo.Permission;

public interface PermissionService {

    List<Permission> findAllOptions();

}
