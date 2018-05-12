package model.dao;

import model.persistance.ResponseMessageBook;

public interface Itf_responseMessageBook_dao {
	public boolean save(ResponseMessageBook transientInstance);
	//public List<MessageMember> findResponseMessageMemberByLogin(String login);
}
