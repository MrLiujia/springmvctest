package springmvctest.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Book {
	private Long id;
	private String title;
	private String description;
	
	// 对一关系
	@NotNull
	private Publisher publisher;
	
	// 对多关系
	private List<Author> authors = new ArrayList<>(); // 避免调用getAuthors并进一步使用时NPE

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
