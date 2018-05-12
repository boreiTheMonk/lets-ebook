package modelcron.dao;

import java.util.List;

import modelcron.persistance.BookBk;
import modelcron.persistance.MemberBk;

public interface Itf_bookBk_dao  {
	public static final String TITLE = "b.title";
	
	
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
