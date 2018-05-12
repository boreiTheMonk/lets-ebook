package model.service;

import java.util.List;

import model.dao.Itf_messageGroup_dao;
import model.dao.MessageGroup_dao;
import model.persistance.MessageGroup;

public class MessageGroup_service implements Itf_messageGroup_service {
	Itf_messageGroup_dao serv = new MessageGroup_dao();
	@Override
	public boolean save(MessageGroup mg) {
		// TODO Auto-generated method stub
		return serv.save(mg) ;
	}
	@Override
	public MessageGroup findById(int id) {
		// TODO Auto-generated method stub
		return serv.findById(id);
	}
	@Override
	public List<MessageGroup> loadMessageGroup(int idGroup, int min, int max) {
		// TODO Auto-generated method stub
		return serv.loadMessageGroup(idGroup, min, max);
	}
	@Override
	public MessageGroup merge(MessageGroup detachedInstance) {
		// TODO Auto-generated method stub
		return serv.merge(detachedInstance);
	}

}
