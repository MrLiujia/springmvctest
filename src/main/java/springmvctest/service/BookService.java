package springmvctest.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import springmvctest.pojo.Book;

public interface BookService {

    @PreAuthorize("hasAnyAuthority('PERM_BOOK_RO', 'PERM_BOOK_RW')")
	List<Book> findAll();

    @PreAuthorize("hasAnyAuthority('PERM_BOOK_RO', 'PERM_BOOK_RW')")
    Book findOne(Long id);

    @PreAuthorize("hasAuthority('PERM_BOOK_RW')")
    void create(Book book);
}
