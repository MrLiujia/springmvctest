package springmvctest.mapper;

import java.util.List;

import springmvctest.pojo.Permission;

public interface PermissionMapper {

    List<Permission> findAllOptions();

}
