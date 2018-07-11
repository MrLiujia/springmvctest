package springmvctest.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import springmvctest.pojo.Publisher;

public interface PublisherService {

    @PreAuthorize("hasAuthority('PERM_PUBLISHER_RW')")
    void create(Publisher publisher);

    // 限具备权限PERM_PUBLISHER_RO或者PERM_PUBLISHER_RW的用户访问
    @PreAuthorize("hasAnyAuthority('PERM_PUBLISHER_RO', 'PERM_PUBLISHER_RW')") 
    List<Publisher> findAll();

    @PreAuthorize("hasAnyAuthority('PERM_PUBLISHER_RO', 'PERM_PUBLISHER_RW')")
    Publisher findOne(Long id);

    /**
     * 【权限检查】
     * 使用Spring AOP实现
     * 扫描到并分析service层方法的@PreAuthorize得到执行这些方法的权限要求
     * 当这些方法执行之前，springsecurity会检查所需的权限（从会话中拿到当前登录的用户，将其权限与所需权限比对） 
     * 如果权限具备（权限表达式返回true），允许执行；否则返回403
     */
    
    // 权限检查表达式（仅限具备权限PERM_PUBLISHER_RW的用户访问），若没有权限springsecurity返回403错误码
    @PreAuthorize("hasAuthority('PERM_PUBLISHER_RW')") 
    void update(Publisher publisher);

    @PreAuthorize("hasAnyAuthority('PERM_PUBLISHER_RO', 'PERM_PUBLISHER_RW')")
    List<Publisher> findAllOptions();
}
