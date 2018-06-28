package springmvctest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springmvctest.pojo.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Override
	public List<Author> findAll() {
		List<Author> authors = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			Author author = new Author();
			author.setId((long) (i + 1));
			author.setName("作者" + (i + 1));
			authors.add(author);
		}
		
		return authors;
	}

}
