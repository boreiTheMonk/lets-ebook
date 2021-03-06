package model.persistance;

// Generated 29 juin 2010 01:06:24 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * TagBook generated by hbm2java
 */
public class TagBook implements java.io.Serializable {

	private Integer idTag;
	private String tagName;
	private Set books = new HashSet(0);

	public TagBook() {
	}

	public TagBook(String tagName, Set books) {
		this.tagName = tagName;
		this.books = books;
	}

	public Integer getIdTag() {
		return this.idTag;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}
