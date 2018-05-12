package model.service;

import java.util.List;

import model.dao.Itf_messageBook_dao;
import model.dao.MessageBook_dao;
import model.persistance.MessageBook;

public class MessageBook_service implements Itf_messageBook_service {
	Itf_messageBook_dao dao_mess_book;
	
	
	public MessageBook_service() {
		super();
		// TODO Auto-generated constructor stub
		dao_mess_book= new MessageBook_dao();
	}

	@Override
	public MessageBook findById(int id) {
		// TODO Auto-generated method stub
		return dao_mess_book.findById(id);
	}

	@Override
	public List<MessageBook> loadMessageBook(int idBook, int min, int max) {
		// TODO Auto-generated method stub
		return dao_mess_book.loadMessageBook(idBook, min, max);
	}

	@Override
	public boolean save(MessageBook transientInstance) {
		// TODO Auto-generated method stub
		return dao_mess_book.save(transientInstance);
	}

	@Override
	public MessageBook merge(MessageBook detachedInstance) {
		// TODO Auto-generated method stub
		return dao_mess_book.merge(detachedInstance);
	}

}
