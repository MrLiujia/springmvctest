package springmvctest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springmvctest.mapper.OperatorMapper;
import springmvctest.pojo.Operator;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private OperatorMapper operatorMapper;
    
    @Autowired
    public UserDetailsServiceImpl(OperatorMapper operatorMapper) {
        this.operatorMapper = operatorMapper;
    }
    
    /*
     * 【登录】
     * 用户名   zs
     * 密码       123456
     * 验证 处理 POST /login
     * UserDetails user = UserDetailsServiceImpl.loadUserByUsername("zs")
     * String encodedPassword = user.getPassword();
     * boolean passwordOk = passwordEncoder.matches("123456", encodedPassword);
     * if (passwordOk) 将用户详情放入会话；重定向到触发登录的页面或者默认登录成功页（可配置）
     * else            回到登录页面，显示错误消息（用户名或密码错误）
     */

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Operator operator = operatorMapper.findOneByUsername(username);
        
        if (operator == null) { // 按照接口要求，用户名不存在时必须抛异常UsernameNotFoundException
            throw new UsernameNotFoundException("用户名不存在: " + username);
        } 
        
        // 从mapper得到的是实体operator，需要转换成springsecurity所需的UserDetails对象
        return new UserDetailsImpl(operator);
    }

}
