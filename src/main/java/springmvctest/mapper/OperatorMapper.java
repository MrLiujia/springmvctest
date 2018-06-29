package springmvctest.mapper;

import org.apache.ibatis.annotations.Param;

public interface OperatorMapper {

    void create(@Param("username") String username,
                @Param("password") String encodedPassword);

}
