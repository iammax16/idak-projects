package fr.idak.tutorial.ws.model;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
	private Long bookId;
	private String isbn;
	private String title;
	private BigDecimal price;
	private Date dtCreate;
	private Date dtUpdate;

	public Book() {
	}

	public Book(Long bookId, String isbn, String title, BigDecimal price) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(Date dtUpdate) {
		this.dtUpdate = dtUpdate;
	}

	public Date getDtCreate() {
		return dtCreate;
	}

	public void setDtCreate(Date dtCreate) {
		this.dtCreate = dtCreate;
	}
}
