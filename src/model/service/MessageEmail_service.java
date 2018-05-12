package model.service;

import java.util.List;

import model.dao.Itf_messageEmail_dao;
import model.dao.MessageEmail_dao;
import model.persistance.MessageEmail;

public class MessageEmail_service implements Itf_messageEmail_service {

	Itf_messageEmail_dao me_dao = new MessageEmail_dao();
	@Override
	public int countMessageMailbyIdMember(int idMember) {
		// TODO Auto-generated method stub
		return me_dao.countMessageMailbyIdMember(idMember);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return me_dao.delete(id);
	}

	@Override
	public MessageEmail findById(int id) {
		// TODO Auto-generated method stub
		return me_dao.findById(id);
	}

	@Override
	public List<MessageEmail> loadMessageMailbyIdMember(int idMember, int min,
			int max, String orderBy) {
		// TODO Auto-generated method stub
		return me_dao.loadMessageMailbyIdMember(idMember, min, max, orderBy);
	}

	@Override
	public boolean save(MessageEmail me) {
		// TODO Auto-generated method stub
		return me_dao.save(me);
	}

	@Override
	public int countMyMessageMailbyIdMember(int idMember) {
		// TODO Auto-generated method stub
		return me_dao.countMessageMailbyIdMember(idMember);
	}

	@Override
	public List<MessageEmail> loadMyMessageMailbyIdMember(int idMember,
			int min, int max, String orderBy) {
		// TODO Auto-generated method stub
		return me_dao.loadMyMessageMailbyIdMember(idMember, min, max, orderBy);
	}

	@Override
	public MessageEmail findRootById(int id) {
		// TODO Auto-generated method stub
		return me_dao.findRootById(id);
	}

	@Override
	public MessageEmail findLastMessageByRootId(int id) {
		// TODO Auto-generated method stub
		return me_dao.findLastMessageByRootId(id);
	}

	@Override
	public boolean persist(MessageEmail me) {
		// TODO Auto-generated method stub
		return me_dao.persist(me);
	}

}
