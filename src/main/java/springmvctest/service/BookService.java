package springmvctest.service;

import java.util.List;

import springmvctest.pojo.Book;

public interface BookService {

	List<Book> findAll();

}
