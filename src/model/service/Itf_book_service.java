package model.service;

import java.util.List;

import model.persistance.Book;

public interface Itf_book_service {
	public  static final String DATE_DESC = "b.publishingDate desc";
	
	public void persist(Book transientInstance);
	public List<Book> findBooksByMemberId(int memberId);
	public Book findBookByid( int bookId);
	public Book merge(Book detachedInstance) ;
	public void delete(Book persistentInstance) ;
	public List<Book> findBooksByString(String searchWord);
	public int countFindBooksByString(String searchWord);
	public int countAllBooks();
	public List<Book> findBooksByString(String searchWord, int min, int max);
	public int countFindBooksByCategory(int id_category);
	public List<Book> findBooksByCategory(int id_category, int min, int max);
	public boolean save(Book transientInstance);
	public List<Book> getBooks(int min, int max,String orderby);
	
	
	public List<Book> getBooksByMemberId(int idMember, int min, int max,String orderby);
	public int countFindBooksByMemberId(int id_member);
	
	public List<Book> getBooksByGroup(int idGroup, int min, int max,String orderby);
	public int countFindBooksByGroup(int id_category);
	
	public List<Book> getFollowBooksByMemberId(int idMember, int min, int max,String orderby);
	public int countFindFollowBooksByMemberId(int id_member);
	
	public List<Book> getBooksByMemberinGroup(int idGroup,int idMember, int min, int max,String orderby);
	public int countFindBooksByMemberinGroup(int id_group,int idMember);
}
