package springmvctest.service;

public interface OperatorService {

    void create(String username, String password);

    boolean usernameExists(String username);

}
