package model.service;

import java.util.List;

import model.dao.Itf_member_dao;
import model.dao.Itf_messageMember_dao;
import model.dao.Member_dao;
import model.dao.MessageMember_dao;
import model.persistance.Member;
import model.persistance.MessageMember;

public class MessageMember_service implements Itf_messageMember_service {

	 Itf_messageMember_dao messageMember_dao;
	
	public MessageMember_service() {
		super();
		// TODO Auto-generated constructor stub
		messageMember_dao= new MessageMember_dao();
	}

	@Override
	public List<MessageMember> findMessageMemberByLogin(String login) {
		// TODO Auto-generated method stub
		return messageMember_dao.findMessageMemberByLogin(login);
	}

	@Override
	public boolean save(MessageMember transientInstance) {
		// TODO Auto-generated method stub
		return messageMember_dao.save(transientInstance);
	}

	@Override
	public List<MessageMember> loadMessageMember(String login, int min, int max) {
		// TODO Auto-generated method stub
		return messageMember_dao.loadMessageMember(login, min, max);
	}

	@Override
	public MessageMember findById(int id) {
		// TODO Auto-generated method stub
		return messageMember_dao.findById(id);
	}

	@Override
	public MessageMember merge(MessageMember detachedInstance) {
		// TODO Auto-generated method stub
		return messageMember_dao.merge(detachedInstance);
	}

}
