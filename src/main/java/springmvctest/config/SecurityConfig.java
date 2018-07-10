package springmvctest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity // 获得了springSecurityFilterChain组件
public class SecurityConfig {
    // 默认所有请求都需要登录，对于这个后台管理系统来说，可以不改
    
}
