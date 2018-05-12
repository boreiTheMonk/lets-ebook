package model.dao;

import java.util.List;

import model.persistance.Book;
import model.persistance.MessageBook;
import model.persistance.MessageGroup;


public interface Itf_messageGroup_dao {
	boolean save(MessageGroup mg);
	public List<MessageGroup> loadMessageGroup(int idGroup, int min, int max);
	public MessageGroup findById(int id);
	public MessageGroup merge(MessageGroup detachedInstance) ;
}
