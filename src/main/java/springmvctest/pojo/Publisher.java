package springmvctest.pojo;

import java.util.List;

import javax.validation.constraints.Size;

public class Publisher {
	private Long id;
	
	@Size(min = 4, max = 512, message = "4~512字")
	private String name;
	
	@Size(max = 1024, message = "最多1024字")
	private String description;
	
	// 对多关系
	private List<Book> books;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
