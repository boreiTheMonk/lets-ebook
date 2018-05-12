package modelcron.services;

import java.util.List;

import modelcron.dao.BookBk_dao;
import modelcron.dao.Itf_bookBk_dao;
import modelcron.persistance.BookBk;

public class BookBk_service implements Itf_bookBk_service {
	Itf_bookBk_dao book_dao=new BookBk_dao();
	
	@Override
	public void persist(BookBk transientInstance) {
		// TODO Auto-generated method stub
		book_dao.persist(transientInstance);
	}

	@Override
	public List<BookBk> findBooksByMemberId(int memberId) {
		// TODO Auto-generated method stub
		return book_dao.findBooksByMemberId(memberId);
	}

	@Override
	public BookBk findBookByid( int bookId) {
		// TODO Auto-generated method stub
		
		return book_dao.findBookByid(bookId);
		//return book_dao.findBookByid(memberId,bookId);
	}

	@Override
	public BookBk merge(BookBk detachedInstance) {
		// TODO Auto-generated method stub
		return book_dao.merge(detachedInstance) ;
	}

	@Override
	public void delete(BookBk persistentInstance) {
		// TODO Auto-generated method stub
		book_dao.delete(persistentInstance);
	}

	

	

	

	@Override
	public boolean save(BookBk transientInstance) {
		// TODO Auto-generated method stub
		return book_dao.save(transientInstance);
	}

	@Override
	public int countAllBooks() {
		// TODO Auto-generated method stub
		return book_dao.countAllBooks();
	}

	@Override
	public List<BookBk> getBooks(int min, int max, String orderby) {
		// TODO Auto-generated method stub
		return book_dao.getBooks(min, max, orderby);
	}

	
	@Override
	public int countFindBooksByMemberId(int idMember) {
		// TODO Auto-generated method stub
		return book_dao.countFindBooksByMemberId(idMember);
	}

	@Override
	public List<BookBk> getBooksByMemberId(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return book_dao.getBooksByMemberId(idMember, min, max,null);
	}



	

}
