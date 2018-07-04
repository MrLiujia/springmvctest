package springmvctest.service;

import java.util.List;

import springmvctest.pojo.Book;

public interface BookService {

	List<Book> findAll();

    Book findOne(Long id);

    void create(Book book);
}
