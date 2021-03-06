package model.persistance;

// Generated 29 juin 2010 01:06:24 by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * VersionBook generated by hbm2java
 */
public class VersionBook implements java.io.Serializable {

	private Integer idVersionBook;
	private Book book;
	private String description;
	private String linkBook;
	private Integer nbPages;
	private Date publishingDate;
	private String title;
	private Double price;

	public VersionBook() {
	}

	public VersionBook(Book book) {
		this.book = book;
	}

	public VersionBook(Book book, String description, String linkBook,
			Integer nbPages, Date publishingDate, String title, Double price) {
		this.book = book;
		this.description = description;
		this.linkBook = linkBook;
		this.nbPages = nbPages;
		this.publishingDate = publishingDate;
		this.title = title;
		this.price = price;
	}

	public Integer getIdVersionBook() {
		return this.idVersionBook;
	}

	public void setIdVersionBook(Integer idVersionBook) {
		this.idVersionBook = idVersionBook;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLinkBook() {
		return this.linkBook;
	}

	public void setLinkBook(String linkBook) {
		this.linkBook = linkBook;
	}

	public Integer getNbPages() {
		return this.nbPages;
	}

	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	public Date getPublishingDate() {
		return this.publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
