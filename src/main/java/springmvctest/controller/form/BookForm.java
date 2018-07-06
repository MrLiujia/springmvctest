package springmvctest.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import springmvctest.pojo.Author;
import springmvctest.pojo.Book;
import springmvctest.pojo.Publisher;

public class BookForm {
    @Size(min = 1, max = 512, message = "1~512字")
    private String title;
    
    @Size(max = 1024, message = "最多1024字")
    private String description;
    
    @NotNull(message = "必填")
    private Long publisherId;
    
    @Size(min = 1, message = "必填")
    private List<Long> authorIds = new ArrayList<>();
    
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
    
    public List<Long> getAuthorIds() {
        return authorIds;
    }
    public void setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
    }
    
    public Book toBook() {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        
        Publisher publisher = new Publisher();
        publisher.setId(publisherId);
        book.setPublisher(publisher);
        
        for (Long authorId : authorIds) {
            Author author = new Author();
            author.setId(authorId);
            book.getAuthors().add(author);
        }
        
        return book;
    }
}
