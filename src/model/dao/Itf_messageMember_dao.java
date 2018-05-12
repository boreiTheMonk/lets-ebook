package model.dao;

import java.util.List;

import model.persistance.Book;
import model.persistance.Category;
import model.persistance.Member;
import model.persistance.MessageMember;

public interface Itf_messageMember_dao {
	public boolean save(MessageMember transientInstance);
	public List<MessageMember> findMessageMemberByLogin(String login);
	public List<MessageMember> loadMessageMember(String login, int min, int max);
	public MessageMember findById(int id);
	public MessageMember merge(MessageMember detachedInstance) ;
}
