package model.service;

import java.util.List;

import model.dao.Itf_request_friend_dao;
import model.dao.RequestFriend_dao;
import model.persistance.RequestFriend;

public class RequestFriend_service implements Itf_request_friend_service {
Itf_request_friend_dao requestFriend_dao= new RequestFriend_dao();
	
	@Override
	public int countRequestFriendByIdMember(int idMember) {
		// TODO Auto-generated method stub
		return requestFriend_dao.countRequestFriendByIdMember(idMember);
	}

	@Override
	public boolean delete(RequestFriend reqf) {
		// TODO Auto-generated method stub
		return requestFriend_dao.delete(reqf);
	}

	@Override
	public List<RequestFriend> getRequestFriendByIdMember(int idMember) {
		// TODO Auto-generated method stub
		return requestFriend_dao.getRequestFriendByIdMember(idMember);
	}

	@Override
	public boolean save(RequestFriend reqf) {
		// TODO Auto-generated method stub
		return requestFriend_dao.save(reqf);
	}

	@Override
	public RequestFriend findById(int id) {
		// TODO Auto-generated method stub
		return requestFriend_dao.findById(id);
	}

	@Override
	public RequestFriend merge(RequestFriend reqf) {
		// TODO Auto-generated method stub
		return requestFriend_dao.merge(reqf);
	}

	@Override
	public boolean isRequestSent(int idMember, int idMemberFriend) {
		// TODO Auto-generated method stub
		return requestFriend_dao.isRequestSent(idMember, idMemberFriend);
	}

	@Override
	public boolean deleteRequestFriendByFriends(int friends1, int friends2) {
		// TODO Auto-generated method stub
		return requestFriend_dao.deleteRequestFriendByFriends(friends1, friends2);
	}



}
