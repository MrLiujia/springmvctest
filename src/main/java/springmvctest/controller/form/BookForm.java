package springmvctest.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import springmvctest.pojo.Book;
import springmvctest.pojo.Publisher;

public class BookForm {
    @Size(min = 1, max = 512, message = "1~512字")
    private String title;
    
    @Size(max = 1024, message = "最多1024字")
    private String description;
    
    @NotNull(message = "必填")
    private Long publisherId;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
    public Book toBook() {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        
        Publisher publisher = new Publisher();
        publisher.setId(publisherId);
        book.setPublisher(publisher);
        
        return book;
    }
}
