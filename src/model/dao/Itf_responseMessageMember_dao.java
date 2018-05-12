package model.dao;

import java.util.List;

import model.persistance.Book;
import model.persistance.Category;
import model.persistance.Member;
import model.persistance.MessageMember;
import model.persistance.ResponseMessageMember;

public interface Itf_responseMessageMember_dao {
	public boolean save(ResponseMessageMember transientInstance);
	//public List<MessageMember> findResponseMessageMemberByLogin(String login);
}
