package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	@NotEmpty(message = "���� ����")
	private String title;
	
	@NotBlank(message = "���� ����")
	@Length(min = 5, message = "���� 5���� �̻�")
	private String author;
	
	@Size(min = 3, max = 5, message = "3~5�ڸ�")
	@Pattern(regexp = "^[0-9]+$", message = "���ڸ� �Է�")
	private String price;
	
	@NotEmpty(message = "���ǻ� ����")
	private String publisher;
	
	//@NotEmpty(message = "���� ����")
	//@NotBlank(message = "���� ����")
	@NotNull(message = "���� ����")
	private String bookstore;
	
	//@NotEmpty(message = "��ۺ� ����")
	//@NotBlank(message = "��ۺ� ����")
	@NotNull(message = "��ۺ� ����")
	private String kind;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookstore() {
		return bookstore;
	}

	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}
