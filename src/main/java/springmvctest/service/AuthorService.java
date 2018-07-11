package springmvctest.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import springmvctest.pojo.Author;

public interface AuthorService {
    @PreAuthorize("hasAnyAuthority('PERM_AUTHOR_RO', 'PERM_AUTHOR_RW')") 
	List<Author> findAll();

    @PreAuthorize("hasAnyAuthority('PERM_AUTHOR_RO', 'PERM_AUTHOR_RW')")
    Author findOne(Long id);

    @PreAuthorize("hasAuthority('PERM_AUTHOR_RW')")
    void create(Author author);

    @PreAuthorize("hasAuthority('PERM_AUTHOR_RW')")
    void update(Author author);

    @PreAuthorize("hasAnyAuthority('PERM_AUTHOR_RO', 'PERM_AUTHOR_RW')")
    List<Author> findAllOptions();

}
