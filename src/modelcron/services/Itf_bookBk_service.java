package modelcron.services;

import java.util.List;


import modelcron.persistance.BookBk;

public interface Itf_bookBk_service {
	public  static final String DATE_DESC = "b.publishingDate desc";
	
	public void persist(BookBk transientInstance);
	public List<BookBk> findBooksByMemberId(int memberId);

	//public Book findBookByid(int memberId, int bookId);
	public BookBk findBookByid(int bookId);
	
	public BookBk merge(BookBk detachedInstance) ;
	public void delete(BookBk persistentInstance) ;
	
	public boolean save(BookBk transientInstance);
	
	public int countAllBooks();
	public List<BookBk> getBooks(int min, int max,String orderby);
	
	public List<BookBk> getBooksByMemberId(int idMember, int min, int max,String orderby);
	public int countFindBooksByMemberId(int id_member);

}