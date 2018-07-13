package springmvctest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import springmvctest.pojo.Operator;
import springmvctest.pojo.Permission;

/**
 * 继承springsecurity提供的User类获得了UserDetails的基本实现，
 * 如username、password、authorities、enabled等字段及其getter；
 * 还有继承的equals和hashCode会根据username判断两个UserDetailsImpl是否相等，
 * 用于SessionRegistry中维护同一个用户名多次登录导致多个会话的情况
 */
public class UserDetailsImpl extends User {
    private Operator operator;
    
    public UserDetailsImpl(Operator operator) {
        super(operator.getUsername(), 
              operator.getPassword(), 
              operator.getDisabled() == null ? true : !operator.getDisabled(), 
              true, true, true, 
              buildAuthorities(operator));
                
        this.operator = operator;
    }
    
    private static List<GrantedAuthority> buildAuthorities(Operator operator) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + operator.getRole().getName()));
        
        for (Permission permission : operator.getRole().getPermissions()) {
            authorities.add(new SimpleGrantedAuthority("PERM_" + permission.getId()));
        }
        // e.g.
        // ROLE_管理参观者
        // PERM_BOOK_RO
        // PERM_AUTHOR_RO
        // PERM_PUBLISHER_RO
        
        return authorities;
    }

    public Operator getOperator() {
        return operator;
    }
    
}
