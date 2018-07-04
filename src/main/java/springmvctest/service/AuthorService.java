package springmvctest.service;

import java.util.List;

import springmvctest.pojo.Author;

public interface AuthorService {

	List<Author> findAll();

    Author findOne(Long id);

    void create(Author author);

    void update(Author author);

    List<Author> findAllOptions();

}
