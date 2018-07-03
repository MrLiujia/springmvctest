package springmvctest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springmvctest.mapper.OperatorMapper;

@Service
public class OperatorServiceImpl implements OperatorService {
    private OperatorMapper operatorMapper;
    
    private PasswordEncoder passwordEncoder;

    @Autowired
    public OperatorServiceImpl(OperatorMapper operatorMapper,
                               PasswordEncoder passwordEncoder) {
        this.operatorMapper = operatorMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        operatorMapper.create(username, encodedPassword);
    }

    @Override
    public boolean usernameExists(String username) {
        return operatorMapper.usernameExists(username);
    }

}
