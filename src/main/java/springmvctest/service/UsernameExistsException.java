package springmvctest.service;

public class UsernameExistsException extends ServiceException {
    public UsernameExistsException() {
        super("添加管理员-用户名已存在");
    }
}
