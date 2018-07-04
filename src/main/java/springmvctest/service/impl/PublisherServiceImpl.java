package springmvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvctest.mapper.PublisherMapper;
import springmvctest.pojo.Publisher;
import springmvctest.service.PublisherService;

@Service
@Transactional
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

    @Override
    public Publisher findOne(Long id) {
        return publisherMapper.findOne(id);
    }

    @Override
    public void update(Publisher publisher) {
        publisherMapper.update(publisher);
    }

    @Override
    public List<Publisher> findAllOptions() {
        return publisherMapper.findAllOptions();
    }

}
