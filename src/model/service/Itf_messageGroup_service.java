package model.service;

import java.util.List;

import model.persistance.MessageGroup;


public interface Itf_messageGroup_service {
	boolean save(MessageGroup mg);
	public List<MessageGroup> loadMessageGroup(int idGroup, int min, int max);
	public MessageGroup findById(int id);
	public MessageGroup merge(MessageGroup detachedInstance) ;
}
