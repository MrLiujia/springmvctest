package springmvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.mapper.BookMapper;
import springmvctest.pojo.Author;
import springmvctest.pojo.Book;
import springmvctest.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;
    
    @Autowired
	public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> findAll() {
		return bookMapper.findAll();
	}

    @Override
    public Book findOne(Long id) {
        return bookMapper.findOne(id);
    }

    @Override
    public void create(Book book) {
        bookMapper.create(book); // 书名、简介、出版社
        // 作者
        for (Author author : book.getAuthors()) {
            if (author.getId() != null) { // 过滤掉没有选的作者下拉框
                bookMapper.addAuthor(
                        book.getId(), // 来自于insert BOOKS后的主键，前提是使用mybatis的useGeneratedKeys获得了自动生成的主键
                        author.getId() // 来自于表单字段authors[i].id
                        );                
            }
        }
    }
}
