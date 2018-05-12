package model.dao;

import java.util.List;

import model.persistance.Book;
import model.persistance.Member;

public interface Itf_book_dao  {
	public static final String TITLE = "b.title";
	
	
	public void persist(Book transientInstance);
	public List<Book> findBooksByMemberId(int memberId);
	public List<Book> findBooksByString(String searchWord);
	//public Book findBookByid(int memberId, int bookId);
	public Book findBookByid(int bookId);
	public Book findBookOfTheDay();
	public Book merge(Book detachedInstance) ;
	public void delete(Book persistentInstance) ;
	public int countFindBooksByString(String searchWord);
	public List<Book> findBooksByString(String searchWord, int min, int max, String orderby);
	public int countFindBooksByCategory(int id_category);
	public List<Book> findBooksByCategory(int id_category, int min, int max);
	public boolean save(Book transientInstance);
	public List<Book> findSellBooksByLogin(String login, int min, int max, String orderby);
	public List<Book> findBuyBooksByLogin(String login, int min, int max, String orderby);
	public int countAllBooks();
	public List<Book> getBooks(int min, int max,String orderby);
	
	public List<Book> getBooksByMemberId(int idMember, int min, int max,String orderby);
	public int countFindBooksByMemberId(int id_member);

	public List<Book> getBooksByGroup(int idGroup, int min, int max,String orderby);
	public int countFindBooksByGroup(int id_group);
	
	public List<Book> getBooksByMemberinGroup(int idGroup,int idMember, int min, int max,String orderby);
	public int countFindBooksByMemberinGroup(int id_group,int idMember);
	
	public List<Book> getFollowBooksByMemberId(int idMember, int min, int max,String orderby);
	public int countFindFollowBooksByMemberId(int id_member);

}
