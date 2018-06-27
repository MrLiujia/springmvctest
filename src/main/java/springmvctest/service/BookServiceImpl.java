package springmvctest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springmvctest.pojo.Book;

@Service
public class BookServiceImpl implements BookService {

	public List<Book> findAll() {
		List<Book> books = new ArrayList<Book>();

		for (int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setId((long) (i + 1));
			book.setTitle("book" + (i + 1));
			books.add(book);
		}
		
		return books;
	}

}
