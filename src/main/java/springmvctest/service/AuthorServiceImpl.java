package springmvctest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.mapper.AuthorMapper;
import springmvctest.pojo.Author;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	private AuthorMapper authorMapper;
	
	@Autowired
	public AuthorServiceImpl(AuthorMapper authorMapper) {
		this.authorMapper = authorMapper;
	}

	@Override
	public List<Author> findAll() {
		return authorMapper.findAll();
	}

    @Override
    public Author findOne(Long id) {
        return authorMapper.findOne(id);
    }

    @Override
    public void create(Author author) {
        authorMapper.create(author);
    }

    @Override
    public void update(Author author) {
        authorMapper.update(author);
    }

}
