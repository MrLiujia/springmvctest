package springmvctest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import springmvctest.pojo.Role;

public interface RoleMapper {

    List<Role> findAllOptions();

    void create(Role role);
    
    void addPermission(@Param("roleId") Long roleId, 
                       @Param("permissionId") String permissionId);

    Role findOne(Long id);

    void update(Role role);

    void deleteAllPermissionsOfRole(Long roleId);

}
