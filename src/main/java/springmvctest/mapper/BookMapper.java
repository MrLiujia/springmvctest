package springmvctest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import springmvctest.pojo.Book;

public interface BookMapper {
    List<Book> findAll();

    Book findOne(Long id);

    void create(Book book);
    
    void addAuthor(@Param("bookId") Long bookId, 
                   @Param("authorId") Long authorId);
}
