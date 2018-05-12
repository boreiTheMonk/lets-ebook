package model.dao;

import java.util.List;

import model.persistance.Book;
import model.persistance.MessageBook;
import model.persistance.MessageMember;

public interface Itf_messageBook_dao {
	public boolean save(MessageBook transientInstance);
	//public List<MessageBook> findMessageBookByLogin(String login);
	public List<MessageBook> loadMessageBook(int idBook, int min, int max);
	public MessageBook findById(int id);
	public MessageBook merge(MessageBook detachedInstance) ;
}
