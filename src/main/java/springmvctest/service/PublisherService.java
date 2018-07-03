package springmvctest.service;

import java.util.List;

import springmvctest.pojo.Publisher;

public interface PublisherService {

    void create(Publisher publisher);

    List<Publisher> findAll();

    Publisher findOne(Long id);

    void update(Publisher publisher);
}
