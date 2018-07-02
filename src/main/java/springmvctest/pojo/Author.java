package springmvctest.pojo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Author {
	private Long id;
	
	@Size(min = 2, max = 512, message = "2~512字")
	private String name;

	@NotNull(message = "必填")
	private Gender gender;

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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
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
