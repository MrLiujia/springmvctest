package springmvctest.mapper;

import java.util.List;

import springmvctest.pojo.Publisher;

public interface PublisherMapper {

    void create(Publisher publisher);

    List<Publisher> findAll();
}
