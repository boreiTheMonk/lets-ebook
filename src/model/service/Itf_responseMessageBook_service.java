package model.service;

import model.persistance.ResponseMessageBook;


public interface Itf_responseMessageBook_service {
	public boolean save(ResponseMessageBook transientInstance);
	//public List<MessageMember> findResponseMessageMemberByLogin(String login);
}
