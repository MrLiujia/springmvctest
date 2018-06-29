package springmvctest.service;

import java.util.List;

import springmvctest.pojo.Publisher;

public interface PublisherService {

    void create(Publisher publisher);

    List<Publisher> findAll();

}
