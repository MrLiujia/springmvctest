package springmvctest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvctest.mapper.PublisherMapper;
import springmvctest.pojo.Publisher;

@Service
public class PublisherServiceImpl implements PublisherService {
   
    private PublisherMapper publisherMapper;
    
    @Autowired
    public PublisherServiceImpl(PublisherMapper publisherMapper) {
        this.publisherMapper = publisherMapper;
    }

    @Override
    public void create(Publisher publisher) {
        publisherMapper.create(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherMapper.findAll();
    }

}
