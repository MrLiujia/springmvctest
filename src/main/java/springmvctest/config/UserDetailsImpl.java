package springmvctest.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import springmvctest.pojo.Operator;
import springmvctest.pojo.Permission;

public class UserDetailsImpl implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private boolean enabled;
    
    private Operator operator;
    
    public UserDetailsImpl(Operator operator) {
        this.username = operator.getUsername();
        this.password = operator.getPassword();
        this.authorities = buildAuthorities(operator);
        // 若该管理员未指定禁用标志则默认启用
        this.enabled = operator.getDisabled() == null ? true : !operator.getDisabled();
        
        this.operator = operator;
    }

    private List<GrantedAuthority> buildAuthorities(Operator operator) {
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

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public boolean isEnabled() { // 账号启用了吗
        return enabled;
    }
    
    public Operator getOperator() {
        return operator;
    }
    

    @Override
    public boolean isAccountNonExpired() { // 账号没有过期吗
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 账号没有锁定吗
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 密码没有过期吗
        return true;
    }

}
