package model.service;

import java.util.List;

import model.dao.Book_dao;
import model.dao.Itf_book_dao;
import model.persistance.Book;

public class Book_service implements Itf_book_service {
	Itf_book_dao book_dao=new Book_dao();
	
	@Override
	public void persist(Book transientInstance) {
		// TODO Auto-generated method stub
		book_dao.persist(transientInstance);
	}

	@Override
	public List<Book> findBooksByMemberId(int memberId) {
		// TODO Auto-generated method stub
		return book_dao.findBooksByMemberId(memberId);
	}

	@Override
	public Book findBookByid( int bookId) {
		// TODO Auto-generated method stub
		
		return book_dao.findBookByid(bookId);
		//return book_dao.findBookByid(memberId,bookId);
	}

	@Override
	public Book merge(Book detachedInstance) {
		// TODO Auto-generated method stub
		return book_dao.merge(detachedInstance) ;
	}

	@Override
	public void delete(Book persistentInstance) {
		// TODO Auto-generated method stub
		book_dao.delete(persistentInstance);
	}

	@Override
	public List<Book> findBooksByString(String searchWord) {
		// TODO Auto-generated method stub
		return book_dao.findBooksByString(searchWord);
	}

	@Override
	public int countFindBooksByString(String searchWord) {
		// TODO Auto-generated method stub
		return book_dao.countFindBooksByString(searchWord);
	}

	@Override
	public List<Book> findBooksByString(String searchWord, int min, int max) {
		// TODO Auto-generated method stub
		return book_dao.findBooksByString(searchWord, min, max,Book_dao.TITLE);
	}

	@Override
	public int countFindBooksByCategory(int id_category) {
		// TODO Auto-generated method stub
		return book_dao.countFindBooksByCategory(id_category);
	}

	@Override
	public List<Book> findBooksByCategory(int id_category, int min, int max) {
		// TODO Auto-generated method stub
		return book_dao.findBooksByCategory(id_category, min, max);
	}

	@Override
	public boolean save(Book transientInstance) {
		// TODO Auto-generated method stub
		return book_dao.save(transientInstance);
	}

	@Override
	public int countAllBooks() {
		// TODO Auto-generated method stub
		return book_dao.countAllBooks();
	}

	@Override
	public List<Book> getBooks(int min, int max, String orderby) {
		// TODO Auto-generated method stub
		return book_dao.getBooks(min, max, orderby);
	}

	@Override
	public int countFindBooksByGroup(int id_group) {
		// TODO Auto-generated method stub
		return book_dao.countFindBooksByGroup(id_group);
	}

	@Override
	public List<Book> getBooksByGroup(int idGroup, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return book_dao.getBooksByGroup(idGroup, min, max, orderby);
	}

	@Override
	public int countFindBooksByMemberId(int idMember) {
		// TODO Auto-generated method stub
		return book_dao.countFindBooksByMemberId(idMember);
	}

	@Override
	public List<Book> getBooksByMemberId(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return book_dao.getBooksByMemberId(idMember, min, max,null);
	}

	@Override
	public int countFindFollowBooksByMemberId(int idMember) {
		// TODO Auto-generated method stub
		return book_dao.countFindFollowBooksByMemberId(idMember);
	}

	@Override
	public List<Book> getFollowBooksByMemberId(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return book_dao.getFollowBooksByMemberId(idMember, min, max, orderby);
	}

	@Override
	public int countFindBooksByMemberinGroup(int idGroup, int idMember) {
		// TODO Auto-generated method stub
		return book_dao.countFindBooksByMemberinGroup(idGroup, idMember);
	}

	@Override
	public List<Book> getBooksByMemberinGroup(int idGroup, int idMember,
			int min, int max, String orderby) {
		// TODO Auto-generated method stub
		return book_dao.getBooksByMemberinGroup(idGroup, idMember, min, max, orderby);
	}
	
	

}
