package model.persistance;

import java.util.Date;

public class Proof_doc {
	long idProofDoc;
	String url_doc;
	private Date publishingDate;
	String name;
	//gives the book owner
	Book myBook;
	
	
	
	public Proof_doc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proof_doc(long idProofDoc, String url_doc, Book myBook) {
		super();
		this.idProofDoc = idProofDoc;
		this.url_doc = url_doc;
		this.myBook = myBook;
	}
	
	
	public Proof_doc(long idProofDoc, String url_doc, Date publishingDate,
			Book myBook) {
		super();
		this.idProofDoc = idProofDoc;
		this.url_doc = url_doc;
		this.publishingDate = publishingDate;
		this.myBook = myBook;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getIdProofDoc() {
		return idProofDoc;
	}
	public void setIdProofDoc(long idProofDoc) {
		this.idProofDoc = idProofDoc;
	}
	public String getUrl_doc() {
		return url_doc;
	}
	public void setUrl_doc(String url_doc) {
		this.url_doc = url_doc;
	}
	
	public Date getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	public Book getMyBook() {
		return myBook;
	}
	public void setMyBook(Book myBook) {
		this.myBook = myBook;
	}
	
	

}
