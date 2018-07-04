package springmvctest.pojo;

import java.util.List;

import javax.validation.constraints.Size;

public class Book {
	private Long id;
	
	@Size(min = 1, max = 512, message = "1~512字")
	private String title;
	
	@Size(max = 1024, message = "最多1024字")
	private String description;
	
	// 对一关系
	private Publisher publisher;
	
	// 对多关系
	private List<Author> authors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
