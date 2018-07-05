package springmvctest.mapper;

import springmvctest.pojo.Operator;

public interface OperatorMapper {

    void create(Operator operator);

    Boolean usernameExists(String username);
}
