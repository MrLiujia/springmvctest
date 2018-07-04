package springmvctest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.mapper.BookMapper;
import springmvctest.pojo.Book;

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
}
