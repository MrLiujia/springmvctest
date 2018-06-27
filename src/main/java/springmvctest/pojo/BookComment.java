package springmvctest.pojo;

public class BookComment {
	private Long id;
	
	// 对一关系（对应表BOOK_COMMENTS的外键列BOOK_ID）
	private Book book; 
	
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
