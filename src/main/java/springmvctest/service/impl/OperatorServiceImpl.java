package springmvctest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.mapper.OperatorMapper;
import springmvctest.pojo.Operator;
import springmvctest.service.OperatorService;
import springmvctest.service.UsernameExistsException;

@Service
@Transactional // 该类的所有public方法都会应用事务
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
    public void create(Operator operator) {
        if (operatorMapper.usernameExists(operator.getUsername())) {
          throw new UsernameExistsException();
        }
        
        String encodedPassword = passwordEncoder.encode(operator.getPassword());
        operator.setPassword(encodedPassword);
        
        operatorMapper.create(operator);
    }

}
