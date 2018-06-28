package springmvctest.mapper;

import java.util.List;

import springmvctest.pojo.Book;

public interface BookMapper {
    List<Book> findAll();
}
