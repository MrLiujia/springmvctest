package springmvctest.service;

import java.util.List;

import springmvctest.pojo.Role;

public interface RoleService {

    List<Role> findAllOptions();

    void create(Role role);
}
