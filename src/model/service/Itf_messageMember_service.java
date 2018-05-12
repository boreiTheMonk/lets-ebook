package model.service;

import java.util.List;

import model.persistance.MessageMember;

public interface Itf_messageMember_service {
	public boolean save(MessageMember transientInstance);
	public List<MessageMember> findMessageMemberByLogin(String login);
	public List<MessageMember> loadMessageMember(String login, int min, int max);
	public MessageMember findById(int id);
	public MessageMember merge(MessageMember detachedInstance) ;
}
