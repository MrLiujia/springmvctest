package springmvctest.mapper;

import java.util.List;

import springmvctest.pojo.Author;

public interface AuthorMapper {
	Author findOne(Long id);
	
	List<Author> findAll();

    void create(Author author);

    void update(Author author);
}
